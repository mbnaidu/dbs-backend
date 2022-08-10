package net.javaguides.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_table")
public class BankModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column (name = "bic")
	public String bic;
	
	@Column(name = "bank_name")
	public String bankName;
	
	@Column (name = "bank_amount")
	public double bankAmount = (double) 0;

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBankAmount() {
		return bankAmount;
	}

	public void setBankAmount(double bankAmount) {
		this.bankAmount = bankAmount;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bankAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((bic == null) ? 0 : bic.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		BankModel other = (BankModel) obj;
		if (Double.doubleToLongBits(bankAmount) != Double.doubleToLongBits(other.bankAmount))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (bic == null) {
			if (other.bic != null)
				return false;
		} else if (!bic.equals(other.bic))
			return false;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "BankModel [id=" + id + ", bic=" + bic + ", bankName=" + bankName + ", bankAmount=" + bankAmount + "]";
	}
}
