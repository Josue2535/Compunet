package com.example.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dao.EmployeepayhistoryDAO;
import com.example.model.hr.Employeepayhistory;
@Repository
@Transactional
public class EmployeepayhistoryDAOimpl implements EmployeepayhistoryDAO{

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public void insert(Employeepayhistory a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Employeepayhistory a) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
	}

	@Override
	public void delete(Employeepayhistory a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employeepayhistory> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT eph FROM Employeepayhistory eph");
        return query.getResultList();
	}
	
	@Override
	public Optional<Employeepayhistory> get(Integer id) {
		EntityManager em = emf.createEntityManager();
		return Optional.ofNullable(em.find(Employeepayhistory.class, id));
	}
}
