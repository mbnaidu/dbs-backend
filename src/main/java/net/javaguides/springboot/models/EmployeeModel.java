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
@Table(name = "employee_table")
public class EmployeeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_pswd")
	private String empPswd;
	
	@Column(name = "transactions")
	private HashMap<String, Object> transactions;
}
