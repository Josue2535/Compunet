package com.example.daoimpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dao.PersonDAO;
import com.example.model.hr.Employeepayhistory;
import com.example.model.person.Person;
@Repository
@Transactional
public class PersonDAOimpl implements PersonDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public PersonDAOimpl() {
		
	}
	
	@Override
	public Optional<Person> get(Integer id) {
		return Optional.ofNullable(entityManager.find(Person.class, id));
	}

	@Override
	public List<Person> getAll() {
		Query query = entityManager.createQuery("SELECT l FROM Person l");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Person t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));
	}

	@Override
	@Transactional
	public void update(Person t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));
	}

	@Override
	@Transactional
	public void deleteById(Integer locId) {
		Person loc = get(locId).orElse(null);
		executeInsideTransaction(entityManager -> entityManager.remove(loc));
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		//EntityTransaction tx = entityManager.getTransaction();
		try {
			//tx.begin();
			action.accept(entityManager);
			//tx.commit(); 
		}
		catch (RuntimeException e) {
			//tx.rollback();
			throw e;
		}
	}

}
