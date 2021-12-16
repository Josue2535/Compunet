package com.example.front.Controller;

import java.text.ParseException;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.hr.Employeepayhistory;

public interface HistoryPayController {
	public String indexHistoryPay(Model model);
	public String historypayAdd(Model model);
	public String historypayAdd(@ModelAttribute("historypaya") Employeepayhistory employeehistorypay, BindingResult bindingResult, RedirectAttributes redirectAttrs,
			@RequestParam(value="action", required=true) String action, Model model) throws ParseException, IllegalArgumentException;
	public String updateHistoryPay(@PathVariable("id")Integer id, Model model);
	public String updateHistoryPay(@PathVariable("id") Integer id, @RequestParam(value = "action", required = true) String action, Employeepayhistory employeepayhistory1, BindingResult bindingResult, Model model) throws Exception;
	
}
