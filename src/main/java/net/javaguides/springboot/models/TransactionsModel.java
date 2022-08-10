package net.javaguides.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	
	@Column(name = "bank_code")
	private String bankCode;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column(name = "trans_amount")
	private Double transAmount;
	
	@Column(name = "trans_date")
	private String transDate;
	
	@Column(name = "message_code")
	private String messageCode;
	
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

	public Double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(Double transAmount) {
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


	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((messageCode == null) ? 0 : messageCode.hashCode());
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
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		} else if (!bankCode.equals(other.bankCode))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
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
		if (messageCode == null) {
			if (other.messageCode != null)
				return false;
		} else if (!messageCode.equals(other.messageCode))
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
				+ receiverNo + ", transId=" + transId + ", transType=" + transType + ", bankCode=" + bankCode
				+ ", bankName=" + bankName + ", transAmount=" + transAmount + ", transDate=" + transDate
				+ ", messageCode=" + messageCode + "]";
	}

}
