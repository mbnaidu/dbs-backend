package net.javaguides.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import net.javaguides.springboot.services.MessageServices;

@RestController
@RequestMapping("/insert")
@CrossOrigin("*")
@JsonIgnoreType()
public class MessageController {
	
	@Autowired
	MessageServices messageServices;
	
	@PostMapping("/messagesData")
	public void upload(@RequestParam("file") MultipartFile file) {
		try {
			messageServices.upload(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
