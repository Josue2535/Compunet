package com.example.front.Controller;

import java.text.ParseException;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.person.Person;

public interface PersonController {
	public String indexPerson(Model model);
	public String personAdd(Model model);
	public String personAdd(@ModelAttribute("person") Person person, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException;
	public String updatePerson(@PathVariable("id")Integer id, Model model);
	public String updatePerson(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Person person, BindingResult bindingResult, Model model) throws Exception;
	

}
