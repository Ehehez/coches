package com.example.demo.models.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.dao.CocheDAO;
import com.example.demo.models.entities.Coche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocheService {

     @Autowired 
    private CocheDAO usuarioDAO;

    public Coche save(Coche usuario) {
        return usuarioDAO.save(usuario);
    }

    public Coche update(Coche usuario) {
        return usuarioDAO.save(usuario);
    }

    public void delete(Coche usuario) {
        usuarioDAO.delete(usuario);
    }

    public Optional<Coche> findById(int id) {
        return usuarioDAO.findById(id);
    }

    public List<Coche> findAll(){
        return usuarioDAO.findAll(); 
    }

}