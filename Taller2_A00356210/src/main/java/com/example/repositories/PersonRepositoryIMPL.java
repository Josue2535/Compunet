package com.example.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
@Repository
public class PersonRepositoryIMPL implements Person{
	private ArrayList<com.example.model.person.Person> persons;
	public PersonRepositoryIMPL(ArrayList<com.example.model.person.Person> persons) {
		this.persons = new ArrayList<>();
	}
	@Override
	public <S extends com.example.model.person.Person> S save(S entity) {
		boolean ce = false;
		for (int i = 0; i < persons.size(); i++) {
			if(persons.get(i).getBusinessentityid() == entity.getBusinessentityid()) {
				ce = true;
			}
		}
		if(ce == false) {
			persons.add(entity);
		}else {
			deleteById(entity.getBusinessentityid());
			persons.add(entity);
		}
		return null;
	}

	@Override
	public <S extends com.example.model.person.Person> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<com.example.model.person.Person> findById(Integer id) {
		for (int i = 0; i < persons.size(); i++) {
			if(persons.get(i).getBusinessentityid() == id) {
				return Optional.of(persons.get(i));
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
	public Iterable<com.example.model.person.Person> findAll() {
		return persons;
	}

	@Override
	public Iterable<com.example.model.person.Person> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public void deleteById(Integer id) {
		for (int i = 0; i < persons.size(); i++) {
			if(persons.get(i).getBusinessentityid() == id) {
				persons.remove(i);
			}
		}
		
	}

	@Override
	public void delete(com.example.model.person.Person entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends com.example.model.person.Person> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

}
