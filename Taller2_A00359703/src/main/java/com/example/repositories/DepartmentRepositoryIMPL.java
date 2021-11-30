package com.example.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;
@Repository
public class DepartmentRepositoryIMPL implements Department {
	private ArrayList<com.example.model.hr.Department> departmets;
	public DepartmentRepositoryIMPL() {
		this.departmets = new ArrayList<>() ;
	}
	@Override
	public <S extends com.example.model.hr.Department> S save(S entity) {
		departmets.add(entity);
		return null;
	}

	@Override
	public <S extends com.example.model.hr.Department> Iterable<S> saveAll(Iterable<S> entities) {
		
		return null;
	}

	@Override
	public Optional<com.example.model.hr.Department> findById(Integer id) {
		for (int i = 0; i < departmets.size(); i++) {
			if(departmets.get(i).getDepartmentid() == id) {
				return Optional.of(departmets.get(i));
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
	public Iterable<com.example.model.hr.Department> findAll() {
		// TODO Auto-generated method stub
		return departmets;
	}

	@Override
	public Iterable<com.example.model.hr.Department> findAllById(Iterable<Integer> ids) {
		
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return departmets.size();
	}

	@Override
	public void deleteById(Integer id) {
		for (int i = 0; i < departmets.size(); i++) {
			if(departmets.get(i).getDepartmentid() == id) {
				departmets.remove(i);
			}
		}
		
	}

	@Override
	public void delete(com.example.model.hr.Department entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends com.example.model.hr.Department> entities) {
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
