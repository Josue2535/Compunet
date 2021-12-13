package com.example.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public void insert(Person a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Person a) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
	}

	@Override
	public void delete(Person a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT pe FROM Person pe");
        return query.getResultList();
	}
	
	@Override
	public Optional<Person> get(Integer id) {
		EntityManager em = emf.createEntityManager();
		return Optional.ofNullable(em.find(Person.class, id));
	}

}
