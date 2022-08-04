package net.javaguides.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import net.javaguides.springboot.models.CustomerModel;
import net.javaguides.springboot.repositories.CustomerRepository;
import net.javaguides.springboot.services.CustomerServices;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
@JsonIgnoreType()
public class CustomerController {
	@Autowired
	CustomerServices customerServices;
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/custlist")
	public List<CustomerModel> getCustList(){
		return customerServices.getAllCustomers();
	}
	
	@PostMapping("/upload")
	public void upload(@RequestParam("file") MultipartFile file) {
		try {
			customerServices.upload(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
