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

import com.example.dao.EmployeedepartmenthistoryDAO;
import com.example.model.hr.Employee;
import com.example.model.hr.Employeedepartmenthistory;
@Repository
@Transactional
public class EmployeedepartmenthistoryDAOimpl implements EmployeedepartmenthistoryDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EmployeedepartmenthistoryDAOimpl() {
		
	}
	
	@Override
	public Optional<Employeedepartmenthistory> get(Integer id) {
		return Optional.ofNullable(entityManager.find(Employeedepartmenthistory.class, id));
	}

	@Override
	public List<Employeedepartmenthistory> getAll() {
		Query query = entityManager.createQuery("SELECT l FROM Employeedepartmethistory l");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Employeedepartmenthistory t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));
	}

	@Override
	@Transactional
	public void update(Employeedepartmenthistory t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));
	}

	@Override
	@Transactional
	public void deleteById(Integer locId) {
		Employeedepartmenthistory loc = get(locId).orElse(null);
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
