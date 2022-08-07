package net.javaguides.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "transactions_table")
public class TransactionsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "sender_no")
	private String senderNo;
	
	@Column(name = "receiver_no")
	private String receiverNo;
	
	@Column(name = "trans_id")
	private String transId;
	
	@Column(name = "trans_type")
	private String transType;
	
	@Column(name = "trans_amount")
	private String transAmount;
	
	@Column(name = "trans_date")
	private String transDate;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSenderNo() {
		return senderNo;
	}

	public void setSenderNo(String senderNo) {
		this.senderNo = senderNo;
	}

	public String getReceiverNo() {
		return receiverNo;
	}

	public void setReceiverNo(String receiverNo) {
		this.receiverNo = receiverNo;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}


	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((receiverNo == null) ? 0 : receiverNo.hashCode());
		result = prime * result + ((senderNo == null) ? 0 : senderNo.hashCode());
		result = prime * result + ((transAmount == null) ? 0 : transAmount.hashCode());
		result = prime * result + ((transDate == null) ? 0 : transDate.hashCode());
		result = prime * result + ((transId == null) ? 0 : transId.hashCode());
		result = prime * result + ((transType == null) ? 0 : transType.hashCode());
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
		TransactionsModel other = (TransactionsModel) obj;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (receiverNo == null) {
			if (other.receiverNo != null)
				return false;
		} else if (!receiverNo.equals(other.receiverNo))
			return false;
		if (senderNo == null) {
			if (other.senderNo != null)
				return false;
		} else if (!senderNo.equals(other.senderNo))
			return false;
		if (transAmount == null) {
			if (other.transAmount != null)
				return false;
		} else if (!transAmount.equals(other.transAmount))
			return false;
		if (transDate == null) {
			if (other.transDate != null)
				return false;
		} else if (!transDate.equals(other.transDate))
			return false;
		if (transId == null) {
			if (other.transId != null)
				return false;
		} else if (!transId.equals(other.transId))
			return false;
		if (transType == null) {
			if (other.transType != null)
				return false;
		} else if (!transType.equals(other.transType))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TransactionsModel [id=" + id + ", empName=" + empName + ", senderNo=" + senderNo + ", receiverNo="
				+ receiverNo + ", transId=" + transId + ", transType=" + transType + ", transAmount=" + transAmount
				+ ", transDate=" + transDate + "]";
	}

}
