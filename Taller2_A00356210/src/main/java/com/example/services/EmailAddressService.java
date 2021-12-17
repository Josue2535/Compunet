package com.example.services;

import java.util.List;

import com.example.model.hr.Department;
import com.example.model.person.Emailaddress;

public interface EmailAddressService {
	public void saveEmail(Emailaddress d);
	public void upDateEmailaddress(Emailaddress d);
	public Emailaddress findEmailaddressById(Integer id);
	void delete(Integer id);

}
