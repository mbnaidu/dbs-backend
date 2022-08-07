package net.javaguides.springboot.models;

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
	public String bic;
	public String bank_name;
	
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank_name == null) ? 0 : bank_name.hashCode());
		result = prime * result + ((bic == null) ? 0 : bic.hashCode());
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
		if (bank_name == null) {
			if (other.bank_name != null)
				return false;
		} else if (!bank_name.equals(other.bank_name))
			return false;
		if (bic == null) {
			if (other.bic != null)
				return false;
		} else if (!bic.equals(other.bic))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "BankModel [bic=" + bic + ", bank_name=" + bank_name + "]";
	}
}
