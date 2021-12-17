package com.example.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.model.hr.Shift;


@Service
public interface ShiftService {
	
	public void saveShift(Shift p);
	public Shift findShiftById(Integer id);
	public ArrayList<Shift>findAll();
	public void deleteShift(Integer id);
	public void upDateShift(Shift p);
	public long size();

}
