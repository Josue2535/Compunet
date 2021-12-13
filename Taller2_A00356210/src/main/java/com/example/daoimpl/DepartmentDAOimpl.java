package com.example.daoimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dao.DeparmentDAO;
import com.example.model.hr.Department;
import com.example.model.hr.Employee;
@Repository
@Transactional
public class DepartmentDAOimpl implements DeparmentDAO{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public void insert(Department a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(a);
	    em.getTransaction().commit();
	    em.close();
	}

	@Override
	public void update(Department a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
	}

	@Override
	public void delete(Department a) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT de FROM Department de");
        return query.getResultList();	
    }
	@SuppressWarnings("unchecked")
	public List<Department> findByNameGrup(String name) {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("SELECT de FROM Department em WHERE de.grupname = " + "\'"+name+"\'");
        return query.getResultList();
	}

	@Override
	public Optional<Department> get(Integer id) {
		EntityManager em = emf.createEntityManager();
		return Optional.ofNullable(em.find(Department.class, id));
	}

}
