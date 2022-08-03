package net.javaguides.springboot.helpers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "messages_table")

public class MessagesHelper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "message_code")
	private String messageCode;
	
	@Column(name = "message_instructor")
	private String messageInstructor;
}
