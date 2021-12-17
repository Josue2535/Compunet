package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.daoimpl.EmailAddressDAOimpl;
import com.example.model.person.Emailaddress;

public class EmailAddressServiceIMPL implements EmailAddressService{
	
	private EmailAddressDAOimpl dr;
	@Autowired
	public EmailAddressServiceIMPL(EmailAddressDAOimpl dr) {
		this.dr = dr;
	}
	@Override
	public void saveEmail(Emailaddress d) {
		dr.save(d);
		
	}
	@Override
	public void upDateEmailaddress(Emailaddress d) {
		dr.update(d);
		
	}
	@Override
	public Emailaddress findEmailaddressById(Integer id) {
		return dr.findById(id).get();
	}
	@Override
	public void delete(Integer id) {
		dr.deleteById(id);
		
	}
	
	public List<Emailaddress> findAll(){
		return dr.getAll();
	}
	
	public Long size(){
		return (long) dr.getAll().size();
	}
	
}
