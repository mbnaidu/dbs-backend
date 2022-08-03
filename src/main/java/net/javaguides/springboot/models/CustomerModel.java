package net.javaguides.springboot.models;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_table")
public class CustomerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "accNo")
	private Long accNo;
	
	@Column(name = "accNum")
	private String accNum;
	
	@Column(name = "blnc")
	private Long blnc;
	
	@Column(name = "od")
	private Boolean od;
	
	@Column(name = "transactions")
	private HashMap<String, Object> transaction;
}
