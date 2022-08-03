package net.javaguides.springboot.helpers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bank_table")

public class BankHelper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "bic")
	private String bic;
	
	@Column(name = "bank_name")
	private String bankName;
}
