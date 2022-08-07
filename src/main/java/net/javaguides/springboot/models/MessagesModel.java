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
	
	public String message_code;
	public String message_instruction;
	
	public String getMessage_code() {
		return message_code;
	}
	public void setMessage_code(String message_code) {
		this.message_code = message_code;
	}
	public String getMessage_instruction() {
		return message_instruction;
	}
	public void setMessage_instruction(String message_instruction) {
		this.message_instruction = message_instruction;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message_code == null) ? 0 : message_code.hashCode());
		result = prime * result + ((message_instruction == null) ? 0 : message_instruction.hashCode());
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
		if (message_code == null) {
			if (other.message_code != null)
				return false;
		} else if (!message_code.equals(other.message_code))
			return false;
		if (message_instruction == null) {
			if (other.message_instruction != null)
				return false;
		} else if (!message_instruction.equals(other.message_instruction))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "MessagesModel [id=" + id + ", message_code=" + message_code + ", message_instruction="
				+ message_instruction + "]";
	}
}
