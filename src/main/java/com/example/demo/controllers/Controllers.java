package com.example.demo.controllers;


import com.example.demo.models.entities.Usuario;
import com.example.demo.models.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/")
public class Controllers {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public void save() {
        try {
            Usuario user = new Usuario();
            user.setId(2);
            user.setNombre("Hola");
            user.setApellidos("buenas");
            user.setContraseña("tititiit");
            user.setEmail("mail@mail.mail");
            System.out.println("antes de guardar");
            usuarioService.save(user);
            System.out.println("despues de guardar");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @GetMapping("/prueba")
    public String prueba() {
        return "hue";
    }

}