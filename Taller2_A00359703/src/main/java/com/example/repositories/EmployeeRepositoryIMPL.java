package com.example.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;
@Repository
public class EmployeeRepositoryIMPL implements Employee{
	ArrayList<com.example.model.hr.Employee> employees;
	public EmployeeRepositoryIMPL(ArrayList<com.example.model.hr.Employee> employees) {
		this.employees =new ArrayList();
	}
	@Override
	public <S extends com.example.model.hr.Employee> S save(S entity) {
		employees.add(entity);
		return null;
	}

	@Override
	public <S extends com.example.model.hr.Employee> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<com.example.model.hr.Employee> findById(Integer id) {
		for(int i = 0; i<employees.size(); i++) {
			if(employees.get(i).getBusinessentityid()==id) {
				return Optional.of(employees.get(i));
			}
		}
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<com.example.model.hr.Employee> findAll() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Iterable<com.example.model.hr.Employee> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return employees.size();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
				for(int i = 0; i<employees.size(); i++) {
					if(employees.get(i).getBusinessentityid()==id) {
						employees.remove(i);
					}
				}
		
	}

	@Override
	public void delete(com.example.model.hr.Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends com.example.model.hr.Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

}
