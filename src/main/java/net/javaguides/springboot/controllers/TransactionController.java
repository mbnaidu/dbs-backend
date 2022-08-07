package net.javaguides.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import net.javaguides.springboot.models.TransactionsModel;
import net.javaguides.springboot.services.TransactionServices;

@RestController
@RequestMapping("/transaction")
@CrossOrigin("*")
@JsonIgnoreType()
public class TransactionController {
	
	@Autowired
	TransactionServices transactionServices;
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody TransactionsModel transactionData) {
		return transactionServices.addTransaction(transactionData);
	}	
}
