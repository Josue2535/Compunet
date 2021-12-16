package com.example.front.Controller;

import java.text.ParseException;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.hr.Employeedepartmenthistory;

public interface EmployeeDepartmentHistoryController {
	
	public String indexHistoryDepartment(Model model);
	public String historyDepartment(Model model);
	public String addHistoryDeparment(@ModelAttribute("historydepartment") Employeedepartmenthistory historydepartment1, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException;
	public String updateHistoryDepartment(@PathVariable("id")Integer id, Model model);
	public String updateHistoryDepartment(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Employeedepartmenthistory historydepartmenta, BindingResult bindingResult, Model model) throws Exception;
	

}
