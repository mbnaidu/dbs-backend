package net.javaguides.springboot.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import net.javaguides.springboot.helpers.BankHelper;
import net.javaguides.springboot.models.BankModel;
import net.javaguides.springboot.repositories.BankRepository;

@Service
public class BankServices {
	@Autowired
	private BankRepository bankRepository;
	
	private ObjectMapper mapper = new ObjectMapper();
	
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
                //log.info("Object Node : "+rowData);
                for (int k = 0; k < headers.size(); k++) {
                    Cell cell = row.getCell(k);
                    String headerName = headers.get(k);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                        case STRING:
                        		rowData.put(headerName, cell.getStringCellValue());
						default:
							break;
                        }
                    }
                }
                if(!rowData.toString().equals("{}")) {
                	BankModel node = mapper.convertValue(rowData, BankModel.class);
                	bankRepository.save(node);
                }
            }
        }
	}
}
