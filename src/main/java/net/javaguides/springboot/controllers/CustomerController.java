package net.javaguides.springboot.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	CustomerServices customerServices;
	@Autowired
	private CustomerRepository customerRepository;
	@GetMapping("/custlist")
	public List<CustomerModel> getCustList(){
		return customerServices.getAllCustomers();
	}
	
//	@PostMapping("/addcustlist")
//	public List<CustomerModel> addCustList(@RequestBody List<CustomerModel> customerModel) {
////		for(CustomerModel C:customerModel) {
////			log.info("Adding record :"+C);
////			customerRepository.save(C);
////		}
//		return customerModel;
//	}
	
//	@PostMapping("/addcustlist")
//    public List<CustomerModel> addCustList(@RequestBody List<CustomerModel> p) {
//        return (List<CustomerModel>)customerRepository.saveAll(p);
//    }
	
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
