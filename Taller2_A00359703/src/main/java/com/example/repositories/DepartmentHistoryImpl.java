package com.example.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class DepartmentHistoryImpl implements Employeedepartmenthistory{
	private ArrayList<com.example.model.hr.Employeedepartmenthistory> historys;
	public DepartmentHistoryImpl() {
		historys = new ArrayList<>();
	}
	@Override
	public <S extends com.example.model.hr.Employeedepartmenthistory> S save(S entity) {
		historys.add(entity);
		return null;
	}

	@Override
	public <S extends com.example.model.hr.Employeedepartmenthistory> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<com.example.model.hr.Employeedepartmenthistory> findById(Integer id) {
		for(int i = 0; i<historys.size();i++) {
			if(historys.get(i).getId()==id) {
				return Optional.of(historys.get(i));
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
	public Iterable<com.example.model.hr.Employeedepartmenthistory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<com.example.model.hr.Employeedepartmenthistory> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return historys.size();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
				for(int i = 0; i<historys.size();i++) {
					if(historys.get(i).getId()==id) {
						historys.remove(i);
					}
				}
	}

	@Override
	public void delete(com.example.model.hr.Employeedepartmenthistory entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends com.example.model.hr.Employeedepartmenthistory> entities) {
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
