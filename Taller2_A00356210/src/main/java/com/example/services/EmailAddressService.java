package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.hr.Department;
import com.example.model.person.Emailaddress;

@Service

public interface EmailAddressService {
	public void saveEmail(Emailaddress d);
	public void upDateEmailaddress(Emailaddress d);
	public Emailaddress findEmailaddressById(Integer id);
	void delete(Integer id);

}
