package com.example.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dao.EmployeedepartmenthistoryDAO;
import com.example.model.hr.Employeedepartmenthistory;
@Repository
@Transactional
public class EmployeedepartmenthistoryDAOimpl implements EmployeedepartmenthistoryDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public void insert(Employeedepartmenthistory a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(Employeedepartmenthistory a) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
	}

	@Override
	public void delete(Employeedepartmenthistory a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employeedepartmenthistory> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT epd FROM Employeedepartmenthistory epd");
        return query.getResultList();
	}
	
	@Override
	public Optional<Employeedepartmenthistory> get(Integer id) {
		EntityManager em = emf.createEntityManager();
		return Optional.ofNullable(em.find(Employeedepartmenthistory.class, id));
	}

}
