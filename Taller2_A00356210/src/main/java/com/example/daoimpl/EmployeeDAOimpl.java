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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.dao.EmployeeDAO;
import com.example.model.hr.Employee;


@Repository
@Scope("singleton")
public class EmployeeDAOimpl implements EmployeeDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	public EmployeeDAOimpl() {
		
	}
	
	@Override
	public Optional<Employee> get(Long id) {
		return Optional.ofNullable(entityManager.find(Employee.class, id));
	}

	@Override
	public List<Employee> getAll() {
		Query query = entityManager.createQuery("SELECT l FROM Employee l");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Employee t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));
	}

	@Override
	@Transactional
	public void update(Employee t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));
	}

	@Override
	@Transactional
	public void deleteById(Long locId) {
		Employee loc = get(locId).orElse(null);
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

	public List<Employee> findAllByThreshold(long title) {
		Query query = entityManager.createQuery("SELECT l FROM Employee l where l.jobtitle = :title");
		query.setParameter("title", title);
		return query.getResultList();
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByDate(String date) {
        Query query = entityManager.createQuery("SELECT l FROM Employee l where l.hiredate = :date");
		query.setParameter("date", date);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findBetwenDate(String date1,String date2) {

		Query query = entityManager.createQuery("SELECT em FROM Employee em WHERE em.hiredate BETWEEN  date1 AND date2 ORDER BY \"em.person.lastname\" DESC;");
		query.setParameter("date1", date1);
		query.setParameter("date2", date2);
        return query.getResultList();
	}

}
