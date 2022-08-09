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

import net.javaguides.springboot.models.BankModel;
import net.javaguides.springboot.services.BankServices;

@RestController
@RequestMapping("/bank")
@CrossOrigin("*")
@JsonIgnoreType()

public class BankController {

	@Autowired
	BankServices bankServices;
	
	@PostMapping("/insert/bankData")
	public void upload(@RequestParam("file") MultipartFile file) {
		try {
			bankServices.upload(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	Get employee BYID
	@PostMapping("/get/{bic}")
	public BankModel getByBICName(@PathVariable String bic) {
		return bankServices.getByBICName(bic);
	}
//	Get ALL Employees
	@GetMapping("/list")
	public List<BankModel> getListofAllBanks() {
		return bankServices.getAllBanks();
	}
}
