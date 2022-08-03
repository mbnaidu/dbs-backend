package net.javaguides.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "transactions_table")
public class TransactionsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "sender_no")
	private Long senderNo;
	
	@Column(name = "receiver_no")
	private Long receiverNo;
	
	@Column(name = "trans_id")
	private Long transId;
	
	@Column(name = "trans_amount")
	private Long transAmount;
	
	@Column(name = "trans_date")
	private String transDate;
}
