package net.javaguides.springboot.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	//@Column(name = "accNo")
	private Long acc_no;
	
	@Column(name = "accName")
	private String acc_name;
	
	@Column(name = "blnc")
	private Long blnc;
	
	@Column(name = "od")
	private Boolean od;

	public Long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(Long acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public Long getBlnc() {
		return blnc;
	}

	public void setBlnc(Long blnc) {
		this.blnc = blnc;
	}

	public Boolean getOd() {
		return od;
	}

	public void setOd(Boolean od) {
		this.od = od;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acc_name == null) ? 0 : acc_name.hashCode());
		result = prime * result + ((acc_no == null) ? 0 : acc_no.hashCode());
		result = prime * result + ((blnc == null) ? 0 : blnc.hashCode());
		result = prime * result + ((od == null) ? 0 : od.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerModel other = (CustomerModel) obj;
		if (acc_name == null) {
			if (other.acc_name != null)
				return false;
		} else if (!acc_name.equals(other.acc_name))
			return false;
		if (acc_no == null) {
			if (other.acc_no != null)
				return false;
		} else if (!acc_no.equals(other.acc_no))
			return false;
		if (blnc == null) {
			if (other.blnc != null)
				return false;
		} else if (!blnc.equals(other.blnc))
			return false;
		if (od == null) {
			if (other.od != null)
				return false;
		} else if (!od.equals(other.od))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerModel [acc_no=" + acc_no + ", acc_name=" + acc_name + ", blnc=" + blnc + ", od=" + od + "]";
	}
	
//	@JsonIgnore()
//	@Column(name = "transactions")
//	private HashMap<String, Object> transaction;
	
	
}
