package net.javaguides.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.models.TransactionsModel;
import net.javaguides.springboot.repositories.TransactionsRespository;

@Service
public class TransactionServices {

	@Autowired
	private TransactionsRespository transactionsRespository;
	
//	To save all customers
	public String addTransaction(TransactionsModel transactionDeatils) {
		transactionsRespository.save(transactionDeatils);
		return "saved";
	}
}
