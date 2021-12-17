package com.example.daoimpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.dao.ShiftDAO;
import com.example.model.hr.Shift;


@Repository
@Transactional
public class ShiftDAOimpl implements ShiftDAO {

		@PersistenceContext
		private EntityManager entityManager;
		
		public ShiftDAOimpl() {
			
		}
		
		@Override
		public Optional<Shift> get(Integer id) {
			return Optional.ofNullable(entityManager.find(Shift.class, id));
		}

		@Override
		public List<Shift> getAll() {
			Query query = entityManager.createQuery("SELECT l FROM Shift l");
			return query.getResultList();
		}

		@Override
		@Transactional
		public void save(Shift t) {
			executeInsideTransaction(entityManager -> entityManager.persist(t));
		}

		@Override
		@Transactional
		public void update(Shift t) {
			executeInsideTransaction(entityManager -> entityManager.merge(t));
		}

		@Override
		@Transactional
		public void deleteById(Integer locId) {
			Shift loc = get(locId).orElse(null);
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