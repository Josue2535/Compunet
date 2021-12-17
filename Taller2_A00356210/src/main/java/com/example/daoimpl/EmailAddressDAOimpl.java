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

import com.example.dao.EmailAddressDAO;
import com.example.model.person.Emailaddress;

	@Repository
	@Scope("singleton")
	public class EmailAddressDAOimpl implements EmailAddressDAO {
		
		@PersistenceContext
		private EntityManager entityManager;

		public EmailAddressDAOimpl() {

		}

		@Override
		public Optional<Emailaddress> get(Integer id) {
			return Optional.ofNullable(entityManager.find(Emailaddress.class, id));
		}
		
		public Optional<Emailaddress> findById(Integer id) {
			return Optional.ofNullable(entityManager.find(Emailaddress.class, id));
		}

		@Override
		public List<Emailaddress> getAll() {
			Query query = entityManager.createQuery("SELECT a FROM Autotransition a");
			return query.getResultList();
		}

		@Override
		@Transactional
		public void save(Emailaddress aut) {
			executeInsideTransaction(entityManager -> entityManager.persist(aut));
		}

		@Override
		@Transactional
		public void update(Emailaddress aut) {
			executeInsideTransaction(entityManager -> entityManager.merge(aut));
		}

		@Override
		@Transactional
		public void deleteById(Integer autId) {
			Emailaddress aut = get(autId).orElse(null);
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

		public List<Emailaddress> findAllByNameGrup(String nameGrup) {
			Query query = entityManager.createQuery("SELECT a FROM Emailaddress a WHERE a..groupname = :grupname");
			query.setParameter("grupname", nameGrup);
			return query.getResultList();
		}
		

		
	}
