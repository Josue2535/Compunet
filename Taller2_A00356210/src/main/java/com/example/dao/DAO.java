package com.example.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T,K> {
    void insert(T a);
    
    void update(T a);
    
    void delete(T a);
    
    List<T> findAll();
    
    Optional<T> get(K id);
}
