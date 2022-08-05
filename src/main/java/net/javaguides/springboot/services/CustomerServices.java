package net.javaguides.springboot.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import net.javaguides.springboot.models.CustomerModel;
import net.javaguides.springboot.repositories.CustomerRepository;

@Service
public class CustomerServices {

	@Autowired
	private CustomerRepository customerRepository;

    private ObjectMapper mapper = new ObjectMapper();
    
//	To save all customers
	public String setAllCustomers(CustomerModel custms) {
		customerRepository.save(custms);
		return "saved";
	}
//  To get all customers 
	public List<CustomerModel> getAllCustomers(){
		return customerRepository.findAll();
	}
	public void upload(MultipartFile file) throws Exception {
		
		Path tempDir = Files.createTempDirectory("");
		File tempFile = tempDir.resolve( file.getOriginalFilename ()).toFile ();
		file.transferTo(tempFile);
		Workbook workbook = WorkbookFactory.create(tempFile );
		Sheet sheet = workbook.getSheetAt(0);
		List<String> headers = new ArrayList<String>();
        for (int j = 0; j <= sheet.getLastRowNum(); j++) {
        	Row row = sheet.getRow(j);
        	if (j == 0) {
                // reading sheet header's name
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    headers.add(row.getCell(k).getStringCellValue());
                }
            } else {
                // reading work sheet data
                ObjectNode rowData = mapper.createObjectNode();
                for (int k = 0; k < headers.size(); k++) {
                    Cell cell = row.getCell(k);
                    String headerName = headers.get(k);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                        case BOOLEAN:
                            rowData.put(headerName, cell.getBooleanCellValue());
                            break;
                        case NUMERIC:
                        	String str = NumberToTextConverter.toText(cell.getNumericCellValue());
                        	long l=Long.parseLong(str);
                            rowData.put(headerName, l);
                            break;
                        case STRING:
                        	if(cell.getStringCellValue().equalsIgnoreCase("Yes")) {
                        		rowData.put(headerName, true);
	
                        	}else if(cell.getStringCellValue().equalsIgnoreCase("No")) {
                        		rowData.put(headerName, false);

							}
                        	else {
                        		rowData.put(headerName, cell.getStringCellValue());

                        	}
						default:
							break;
                        }
                    }
                }
                if(!rowData.toString().equals("{}")) {
                	CustomerModel node = mapper.convertValue(rowData, CustomerModel.class);
                	customerRepository.save(node);
                }
            }
        }
	}
}
