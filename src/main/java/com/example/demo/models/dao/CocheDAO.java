package com.example.demo.models.dao;

import java.util.List;

import com.example.demo.models.entities.Coche;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheDAO extends CrudRepository<Coche, Integer> {

    public List<Coche> findAll();
}