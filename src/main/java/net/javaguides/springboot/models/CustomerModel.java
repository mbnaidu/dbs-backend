package net.javaguides.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "accNo")
	public String accNo;
	
	@Column(name = "accName")
	public String accName;
	
	@Column(name = "balance")
	public Double blnc;
	
	@Column(name = "overDraft")
	public boolean od;
	
	@Column(name = "debited")
	public Double debited = (double) 0;

	public String getaccNo() {
		return accNo;
	}

	public void setaccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getaccName() {
		return accName;
	}

	public void setaccName(String accName) {
		this.accName = accName;
	}

	public Double getBlnc() {
		return blnc;
	}

	public void setBlnc(Double blnc) {
		this.blnc = blnc;
	}

	public boolean isOd() {
		return od;
	}

	public void setOd(boolean od) {
		this.od = od;
	}
	
	public Double getDebited() {
		return debited;
	}

	public void setDebited(Double debited) {
		this.debited = debited;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accName == null) ? 0 : accName.hashCode());
		result = prime * result + ((accNo == null) ? 0 : accNo.hashCode());
		result = prime * result + ((blnc == null) ? 0 : blnc.hashCode());
		result = prime * result + ((debited == null) ? 0 : debited.hashCode());
		result = prime * result + (od ? 1231 : 1237);
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
		if (accName == null) {
			if (other.accName != null)
				return false;
		} else if (!accName.equals(other.accName))
			return false;
		if (accNo == null) {
			if (other.accNo != null)
				return false;
		} else if (!accNo.equals(other.accNo))
			return false;
		if (blnc == null) {
			if (other.blnc != null)
				return false;
		} else if (!blnc.equals(other.blnc))
			return false;
		if (debited == null) {
			if (other.debited != null)
				return false;
		} else if (!debited.equals(other.debited))
			return false;
		if (od != other.od)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerModel [id=" + id + ", accNo=" + accNo + ", accName=" + accName + ", blnc=" + blnc + ", od=" + od
				+ ", debited=" + debited + "]";
	}

}
