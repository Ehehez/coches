package com.example.demo.models.dao;

import java.util.List;

import com.example.demo.models.entities.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    public List<Usuario> findAll();
}
