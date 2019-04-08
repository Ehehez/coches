package com.example.demo.controllers;

import java.sql.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.models.entities.Usuario;
import com.example.demo.models.entities.UsuarioEmpresa;
import com.example.demo.models.services.UsuarioEmpresaService;
import com.example.demo.models.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioEmpresaService ueService;

    @GetMapping("/crear")
    public Usuario save(@PathParam("nombre") String nombre, @PathParam("apellidos") String apellidos,
            @PathParam("contraseña") String contraseña, @PathParam("email") String email) {
        Usuario user = null;
        try {
            user = new Usuario();
            user.setNombre(nombre);
            user.setApellidos(apellidos);
            user.setContraseña(contraseña);
            user.setEmail(email);
            Date dateobj = new Date(System.currentTimeMillis());
            user.setCreated(dateobj);
            user.setUpdated(dateobj);

            usuarioService.save(user);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return user;
    }

    @GetMapping("/mostrar")
    public String mostrar() {
        // ModelAndView mav = new ModelAndView("/mostrar");
        List<Usuario> usuarios = usuarioService.findAll();
        String b = "";
        for (Usuario a : usuarios) {
            b += "\n Nombre :" + a.getNombre() + "\t ID: " + a.getId();
        }

        return b;
    }

    @GetMapping("/update")
    public Usuario update(@PathParam("id") int id, @PathParam("nombre") String nombre,
            @PathParam("apellidos") String apellidos, @PathParam("contraseña") String contraseña,
            @PathParam("email") String email) {
        Usuario user = new Usuario();
        if (usuarioService.findById(id).toString() != "Optional.empty") {

            user.setId(id);

            user.setNombre(nombre);
            user.setApellidos(apellidos);
            user.setContraseña(contraseña);
            user.setEmail(email);
            Date dateobj = new Date(System.currentTimeMillis());
            user.setCreated(dateobj);
            user.setUpdated(dateobj);
            usuarioService.update(user);
        }
        return user;
    }

    @GetMapping("/del")
    public Usuario delete(@PathParam("id") int id) {
        Usuario user = new Usuario();
        if (usuarioService.findById(id).orElse(null) != null) {
            for (UsuarioEmpresa a : ueService.findAll()) {
                if (a.getUsuario().getId() == id) {
                    ueService.delete(a);
                }
            }
            usuarioService.delete(usuarioService.findById(id).orElse(null));
        }
        return user;
    }
}