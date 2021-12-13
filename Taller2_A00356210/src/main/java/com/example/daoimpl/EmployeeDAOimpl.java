package com.example.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dao.EmployeeDAO;
import com.example.model.hr.Employee;
@Repository
@Transactional
public class EmployeeDAOimpl implements EmployeeDAO{
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public void insert(Employee a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(a);
	    em.getTransaction().commit();
	    em.close();
	}

	@Override
	public void update(Employee a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
	}

	@Override
	public void delete(Employee a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT em FROM Employee em");
        return query.getResultList();	}

	@Override
	public Optional<Employee> get(Integer id) {
		EntityManager em = emf.createEntityManager();
		return Optional.ofNullable(em.find(Employee.class, id));
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByTitle(String title) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT em FROM Employee em WHERE em.jobtitle = " + "\'"+title+"\'");
        return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByDate(String date) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT em FROM Employee em WHERE em.hiredate = " + "\'"+date+"\'");
        return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findBetwenDate(String date1,String date2) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT em FROM Employee em WHERE em.hiredate BETWEEN  " + "\'"+date1+"\' AND"+"\'"+date1+"\'"+"ORDER BY \"em.person.lastname\" DESC;");
        return query.getResultList();
	}

}
