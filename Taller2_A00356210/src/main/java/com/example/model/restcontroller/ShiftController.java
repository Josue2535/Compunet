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

import com.example.model.hr.Shift;
import com.example.model.person.Person;
import com.example.services.PersonServiceIMPL;
import com.example.services.ShiftServiceIMPL;

@Controller
@RequestMapping("/api/shift/")
public class ShiftController {
	ShiftServiceIMPL shiftService;
	
	@Autowired
	public ShiftController(ShiftServiceIMPL shiftService) {
		this.shiftService = shiftService;
	}
	//----------------------------------------SHIFT----------------------------------------------
	@GetMapping
	public List<Shift> indexDepartmentHistory() {
		return shiftService.findAll();
	}
	@PutMapping
	public void updateShift(@RequestBody Shift de) {
		shiftService.upDateShift(de);
	}

	@DeleteMapping("/{id}")
	public void deleteShift(@PathVariable("id") Integer id) {
		shiftService.deleteShift(id);
	}

	@GetMapping("/{id}")
	public Shift getShiftById(@PathVariable("id") Integer id) {
		Shift temp = shiftService.findShiftById(id);
		if(temp == null) {
			throw new IllegalArgumentException("Invalid id");
		}
		return temp;
	}

}
