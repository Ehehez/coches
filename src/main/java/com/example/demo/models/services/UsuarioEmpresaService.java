package com.example.demo.models.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.dao.UsuarioEmpresaDAO;
import com.example.demo.models.entities.UsuarioEmpresa;
import com.example.demo.models.entities.UsuarioEmpresaPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEmpresaService {

     @Autowired 
    private UsuarioEmpresaDAO usuarioDAO;

    public UsuarioEmpresa save(UsuarioEmpresa usuario) {
        return usuarioDAO.save(usuario);
    }

    public UsuarioEmpresa update(UsuarioEmpresa usuario) {
        return usuarioDAO.save(usuario);
    }

    public void delete(UsuarioEmpresa usuario) {
        usuarioDAO.delete(usuario);
    }

    public Optional<UsuarioEmpresa> findById(UsuarioEmpresaPK id) {
        return usuarioDAO.findById(id);
    }

    public List<UsuarioEmpresa> findAll(){
        return usuarioDAO.findAll(); 
    }


}