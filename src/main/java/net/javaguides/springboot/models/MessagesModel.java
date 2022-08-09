package net.javaguides.springboot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages_table")
public class MessagesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public String messageCode;
	public String messageInstruction;
	
	public String getmessageCode() {
		return messageCode;
	}
	public void setmessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getmessageInstruction() {
		return messageInstruction;
	}
	public void setmessageInstruction(String messageInstruction) {
		this.messageInstruction = messageInstruction;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageCode == null) ? 0 : messageCode.hashCode());
		result = prime * result + ((messageInstruction == null) ? 0 : messageInstruction.hashCode());
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
		MessagesModel other = (MessagesModel) obj;
		if (messageCode == null) {
			if (other.messageCode != null)
				return false;
		} else if (!messageCode.equals(other.messageCode))
			return false;
		if (messageInstruction == null) {
			if (other.messageInstruction != null)
				return false;
		} else if (!messageInstruction.equals(other.messageInstruction))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "MessagesModel [id=" + id + ", messageCode=" + messageCode + ", messageInstruction="
				+ messageInstruction + "]";
	}
}
