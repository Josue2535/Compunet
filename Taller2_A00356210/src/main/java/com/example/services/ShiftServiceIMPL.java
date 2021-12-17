package com.example.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.daoimpl.ShiftDAOimpl;
import com.example.model.hr.Shift;
@Service
public class ShiftServiceIMPL implements ShiftService{
	private ShiftDAOimpl shiftrepo;
	
	public ShiftServiceIMPL() {
		
	}
	@Override
	public void saveShift(Shift p) {
		shiftrepo.save(p);
		
	}

	@Override
	public Shift findShiftById(Integer id) {
		Shift temp = shiftrepo.get(id).get();
		if(temp == null) {
			throw new NullPointerException();
		}
		return temp;
	}

	@Override
	public ArrayList<Shift> findAll() {
		return (ArrayList<Shift>) shiftrepo.getAll();
	}

	@Override
	public void deleteShift(Integer id) {
		shiftrepo.deleteById(id);
		
	}

	@Override
	public void upDateShift(Shift p) {
		shiftrepo.update(p);
		
	}

	@Override
	public long size() {
		return shiftrepo.getAll().size();
	}

}
