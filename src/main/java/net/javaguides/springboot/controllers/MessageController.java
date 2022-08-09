package net.javaguides.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import net.javaguides.springboot.models.MessagesModel;
import net.javaguides.springboot.services.MessageServices;

@RestController
@RequestMapping("/messages")
@CrossOrigin("*")
@JsonIgnoreType()
public class MessageController {
	
	@Autowired
	MessageServices messageServices;
	
	@PostMapping("insert/messagesData")
	public void upload(@RequestParam("file") MultipartFile file) {
		try {
			messageServices.upload(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

//	Get ALL Employees
	@GetMapping("/list")
	public List<MessagesModel> getListofAllMessages() {
		return messageServices.getAllMessages();
	}
//	Get employee BYID
	@PostMapping("/get/{messageCode}")
	public MessagesModel getByMessageCode(@PathVariable String messageCode) {
		return messageServices.getByMessageCode(messageCode);
	}
}
