package com.example.model.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.person.Emailaddress;
import com.example.model.person.Person;
import com.example.services.EmailAddressServiceIMPL;
import com.example.services.PersonServiceIMPL;

@Controller
@RequestMapping("/api/email/")
public class EmailAddressController {
EmailAddressServiceIMPL EmailService;
	
	@Autowired
	public EmailAddressController(EmailAddressServiceIMPL EmailService) {
		this.EmailService = EmailService;
	}
	//----------------------------------------PERSON----------------------------------------------
	@GetMapping
	public List<Emailaddress> indexEmail() {
		return EmailService.findAll();
	}
	@PutMapping
	public void updateEmail(@RequestBody Emailaddress de) {
		EmailService.upDateEmailaddress(de);
	}

	@DeleteMapping("/{id}")
	public void deleteEmail(@PathVariable("id") Integer id) {
		EmailService.delete(id);
	}

	@GetMapping("/{id}")
	public Emailaddress getById(@PathVariable("id") Integer id) {
		Emailaddress temp = EmailService.findEmailaddressById(id);
		if(temp == null) {
			throw new IllegalArgumentException("Invalid id");
		}
		return temp;
	}
}
