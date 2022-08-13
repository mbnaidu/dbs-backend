
package net.javaguides.springboot.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import net.javaguides.springboot.models.CustomerModel;
import net.javaguides.springboot.services.CustomerServices;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
@JsonIgnoreType()
public class CustomerController {
	
	@Autowired
	CustomerServices customerServices;
		
	@PostMapping("insert/customerData")
	public void upload(@RequestParam("file") MultipartFile file) {
		try {
			customerServices.upload(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Get employee BYID
	@PostMapping("/get/{accNo}")
	public CustomerModel getByAccountNumber(@PathVariable String accNo) {
		return customerServices.getByAccountNumber(accNo);
	}
	
//	Get ALL Employees
	@GetMapping("/list")
	public List<CustomerModel> getListofAllCust() {
		return customerServices.getAllCustomers();
	}
}
