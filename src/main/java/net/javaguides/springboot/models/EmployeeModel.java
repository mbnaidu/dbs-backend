package net.javaguides.springboot.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee_table")
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	@Column(name = "emp_name")
	public String empName;
	
	@Column(name = "emp_pswd")
	private String empPswd;
	
	@Column(name = "status")
	private Boolean status = true;
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPswd() {
		return empPswd;
	}

	public void setEmpPswd(String empPswd) {
		this.empPswd = empPswd;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empPswd == null) ? 0 : empPswd.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		EmployeeModel other = (EmployeeModel) obj;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empPswd == null) {
			if (other.empPswd != null)
				return false;
		} else if (!empPswd.equals(other.empPswd))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", empName=" + empName + ", empPswd=" + empPswd + ", status=" + status + "]";
	}

}
