package com.example.daoimpl;



import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DeparmentDAO;
import com.example.model.hr.Department;



@Repository
@Scope("singleton")
public class DepartmentDAOimpl implements DeparmentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public DepartmentDAOimpl() {

	}

	@Override
	public Optional<Department> get(Integer id) {
		return Optional.ofNullable(entityManager.find(Department.class, id));
	}
	
	public Optional<Department> findById(Integer id) {
		return Optional.ofNullable(entityManager.find(Department.class, id));
	}

	@Override
	public List<Department> getAll() {
		Query query = entityManager.createQuery("SELECT a FROM Autotransition a");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Department aut) {
		executeInsideTransaction(entityManager -> entityManager.persist(aut));
	}

	@Override
	@Transactional
	public void update(Department aut) {
		executeInsideTransaction(entityManager -> entityManager.merge(aut));
	}

	@Override
	@Transactional
	public void deleteById(Integer autId) {
		Department aut = get(autId).orElse(null);
		executeInsideTransaction(entityManager -> entityManager.remove(aut));
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

	public List<Department> findAllByNameGrup(String nameGrup) {
		Query query = entityManager.createQuery("SELECT a FROM Department a WHERE a..groupname = :grupname");
		query.setParameter("grupname", nameGrup);
		return query.getResultList();
	}
	

	
}
