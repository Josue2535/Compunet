package com.example.repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.model.user.User;
@Repository
public class UserRrepositoryImp implements UserRepository{
	ArrayList<User> users;
	public UserRrepositoryImp(ArrayList<User> users) {
		this.users = users;
	}
	@Override
	public <S extends User> S save(S entity) {
		users.add(entity);
		return null;
	}

	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUserName(String userName) {
		for(int i = 0; i<users.size();i++) {
			if(users.get(i).getUsername() == userName) {
				return users.get(i);
			}
		}
		return null;
	}


}
