package com.example.demo.models.dao;

import java.util.List;

import com.example.demo.models.entities.UsuarioEmpresa;
import com.example.demo.models.entities.UsuarioEmpresaPK;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEmpresaDAO extends CrudRepository<UsuarioEmpresa, UsuarioEmpresaPK> {

    public List<UsuarioEmpresa> findAll();

}