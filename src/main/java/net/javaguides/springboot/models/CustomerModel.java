package net.javaguides.springboot.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class CustomerModel {
	@Id
	public String acc_no;
	public String acc_name;
	public String blnc;
	public boolean od;

	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public String getBlnc() {
		return blnc;
	}

	public void setBlnc(String blnc) {
		this.blnc = blnc;
	}

	public boolean isOd() {
		return od;
	}

	public void setOd(boolean od) {
		this.od = od;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acc_name == null) ? 0 : acc_name.hashCode());
		result = prime * result + ((acc_no == null) ? 0 : acc_no.hashCode());
		result = prime * result + ((blnc == null) ? 0 : blnc.hashCode());
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
		if (od != other.od)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Root [acc_no=" + acc_no + ", acc_name=" + acc_name + ", blnc=" + blnc + ", od=" + od + "]";
	}

}
