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

import com.example.dao.EmployeepayhistoryDAO;
import com.example.model.hr.Employee;
import com.example.model.hr.Employeedepartmenthistory;
import com.example.model.hr.Employeepayhistory;
@Repository
@Transactional
public class EmployeepayhistoryDAOimpl implements EmployeepayhistoryDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public EmployeepayhistoryDAOimpl() {
		
	}
	
	@Override
	public Optional<Employeepayhistory> get(Long id) {
		return Optional.ofNullable(entityManager.find(Employeepayhistory.class, id));
	}

	@Override
	public List<Employeepayhistory> getAll() {
		Query query = entityManager.createQuery("SELECT l FROM Employeepayhistory l");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Employeepayhistory t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));
	}

	@Override
	@Transactional
	public void update(Employeepayhistory t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));
	}

	@Override
	@Transactional
	public void deleteById(Long locId) {
		Employeepayhistory loc = get(locId).orElse(null);
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
	public List<Employee> findByDate(String date) {
        Query query = entityManager.createQuery("SELECT l FROM Employeepayhistory l where l.modifieddate = :date");
		query.setParameter("date", date);
		return query.getResultList();
	}
}
