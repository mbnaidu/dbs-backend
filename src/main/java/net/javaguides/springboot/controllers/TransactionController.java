package net.javaguides.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import net.javaguides.springboot.models.BankModel;
import net.javaguides.springboot.models.CustomerModel;
import net.javaguides.springboot.models.TransactionsModel;
import net.javaguides.springboot.repositories.BankRepository;
import net.javaguides.springboot.repositories.CustomerRepository;
import net.javaguides.springboot.services.TransactionServices;

@RestController
@RequestMapping("/transaction")
@CrossOrigin("*")
@JsonIgnoreType()
public class TransactionController {
	
	@Autowired
	TransactionServices transactionServices;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	BankRepository bankRepository;
	@PostMapping("/add")
	public String addEmployee(@RequestBody TransactionsModel transactionData) {
		
		CustomerModel cModel = customerRepository.findByAccNo(transactionData.getSenderNo());
		cModel.setBlnc(cModel.getBlnc()-transactionData.getTransAmount());
		cModel.setDebited(cModel.getDebited() + transactionData.getTransAmount());
		customerRepository.save(cModel);
		
		BankModel bModel = bankRepository.findByBic(transactionData.getBankCode());
		bModel.setBankAmount(bModel.getBankAmount() + transactionData.getTransAmount());
		bankRepository.save(bModel);
		
		return transactionServices.addTransaction(transactionData);
	}
	
//	Get ALL Employees
	@GetMapping("/list")
	public List<TransactionsModel> getListofAllTrans() {
		return transactionServices.getAllTransaction();
	}
}
