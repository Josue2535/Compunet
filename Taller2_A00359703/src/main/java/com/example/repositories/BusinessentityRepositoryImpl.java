package com.example.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;
@Repository
public class BusinessentityRepositoryImpl implements Businessentity{
	
	private ArrayList<com.example.model.person.Businessentity> business;
	
	public BusinessentityRepositoryImpl() {
		this.business = new ArrayList();
	}
	
	@Override
	public <S extends com.example.model.person.Businessentity> S save(S entity) {
		business.add(entity);
		return null;
	}

	@Override
	public <S extends com.example.model.person.Businessentity> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public Optional<com.example.model.person.Businessentity> findById(Integer id) {
		for(int i = 0; i<business.size();i++) {
			if(business.get(i).getBusinessentityid()==id) {
				return Optional.of(business.get(i));
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
	public Iterable<com.example.model.person.Businessentity> findAll() {
		return business;
	}

	@Override
	public Iterable<com.example.model.person.Businessentity> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return business.size();
	}

	@Override
	public void deleteById(Integer id) {
		for(int i = 0; i<business.size();i++) {
			if(business.get(i).getBusinessentityid()==id) {
				business.remove(i);
			}
		}
		
	}

	@Override
	public void delete(com.example.model.person.Businessentity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends com.example.model.person.Businessentity> entities) {
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
