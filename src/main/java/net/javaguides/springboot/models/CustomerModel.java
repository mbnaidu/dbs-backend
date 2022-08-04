package net.javaguides.springboot.models;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_table")
public class CustomerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "accNo")
	private Long accNo;
	
	@Column(name = "accName")
	private String accName;
	
	@Column(name = "blnc")
	private Long blnc;
	
	@Column(name = "od")
	private Boolean od;
	
//	@JsonIgnore()
//	@Column(name = "transactions")
//	private HashMap<String, Object> transaction;
}
