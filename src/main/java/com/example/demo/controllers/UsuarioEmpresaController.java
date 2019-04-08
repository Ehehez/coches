package com.example.demo.controllers;

import java.sql.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.models.entities.UsuarioEmpresa;
import com.example.demo.models.entities.UsuarioEmpresaPK;
import com.example.demo.models.services.UsuarioEmpresaService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/useremp")
public class UsuarioEmpresaController {

    @Autowired
    private UsuarioEmpresaService usuarioService;


    @GetMapping("/crear")
    public UsuarioEmpresa save(@PathParam("idempresa") int idempresa,@PathParam("idusuario") int idusuario) {
        UsuarioEmpresa user = new UsuarioEmpresa();
        try {
            UsuarioEmpresaPK key = new UsuarioEmpresaPK();
            key.setEmpresaid(idempresa);
            key.setUsuarioid(idusuario);
            Date dateobj = new Date(System.currentTimeMillis());
            user.setId(key);
            if (usuarioService.findById(key).orElse(null) == null){
            user.setCreated_at(dateobj);
            user.setUpdated_at(dateobj);
            usuarioService.save(user);
            }
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return user;
    }

    @GetMapping("/mostrar")
    public String mostrar() {
        List<UsuarioEmpresa> usuarios = usuarioService.findAll();
        String b = "";
        for (UsuarioEmpresa a : usuarios) {
            b += "Empresa :" + (a.getEmpresa()).getId() + "\t Usuario: " + a.getUsuario().getId()+ "\n";
        }       
        
        return b;
    }
    

   @GetMapping("/del")
    public UsuarioEmpresa delete(@PathParam("idempresa") int idempresa,@PathParam("idusuario") int idusuario) {
        UsuarioEmpresa user = new UsuarioEmpresa();
        UsuarioEmpresaPK key = new UsuarioEmpresaPK();
            key.setEmpresaid(idempresa);
            key.setUsuarioid(idusuario);
        if (usuarioService.findById(key).orElse(null) != null) {
            user.setId(key);
            usuarioService.delete(user);
            return user;
        }
        return user;
    }
}