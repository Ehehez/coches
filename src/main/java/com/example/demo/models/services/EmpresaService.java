package com.example.demo.models.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.dao.EmpresaDAO;
import com.example.demo.models.entities.Empresa;

import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    /* @Autowired */
    private EmpresaDAO usuarioDAO;

    public Empresa save(Empresa usuario) {
        return usuarioDAO.save(usuario);
    }

    public Empresa update(Empresa usuario) {
        return usuarioDAO.save(usuario);
    }

    public void delete(Empresa usuario) {
        usuarioDAO.delete(usuario);
    }

    public Optional<Empresa> findById(int id) {
        return usuarioDAO.findById(id);
    }

    public List<Empresa> findAll(){
        return usuarioDAO.findAll(); 
    }

}