package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.dao.UsuarioDAO;
import com.example.demo.models.entities.Usuario;


import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    /*@Autowired*/
    private UsuarioDAO usuarioDAO;
    
    public Usuario save(Usuario usuario){
        return usuarioDAO.save(usuario);
    }
    public Usuario update(Usuario usuario){
        return usuarioDAO.save(usuario);
    }
    public void delete(Usuario usuario){
        usuarioDAO.delete(usuario);
    }

    public Usuario findById(int id){
        return usuarioDAO.findOne(id);
    }

    public List<Usuario> findAll(){
        return usuarioDAO.findAll(); 
    }

}