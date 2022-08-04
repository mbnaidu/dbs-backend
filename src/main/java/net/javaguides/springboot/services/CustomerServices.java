package net.javaguides.springboot.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import net.javaguides.springboot.models.CustomerModel;
import net.javaguides.springboot.repositories.CustomerRepository;

@Service
public class CustomerServices {

	@Autowired
	private CustomerRepository customerRepository;
	
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
		Stream<Row> rowStream = StreamSupport.stream (sheet.spliterator(), false) ;
		rowStream.forEach(row -> {
			Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(), false);
			List<Object> cellVals= cellStream.map(cell -> {
				String cellVal = cell.getStringCellValue();
				return cellVal;
			})
			.collect(Collectors.toList());
			System.out.println(cellVals);
		});
	}
}
