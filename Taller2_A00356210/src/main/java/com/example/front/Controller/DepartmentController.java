package com.example.front.Controller;

import java.text.ParseException;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.hr.Department;

public interface DepartmentController {
	public String indexPerson(Model model);
	public String departmentAdd(Model model);
	public String addDeparment(@ModelAttribute("department") Department department, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException;
	public String updateDepartments(@PathVariable("id")Integer id, Model model);
	public String updateDepartments(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Department department, BindingResult bindingResult, Model model) throws Exception;
	

}
