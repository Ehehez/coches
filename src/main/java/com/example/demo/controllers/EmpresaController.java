package com.example.demo.controllers;
import java.sql.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.models.entities.Empresa;
import com.example.demo.models.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/crear")
    public Empresa save(@PathParam("nombre") String nombre) {
        Empresa user = null;
        try {
            user = new Empresa();
            user.setNombreEmpresa(nombre);
            Date dateobj = new Date(System.currentTimeMillis());
            user.setCreated_at(dateobj);
            user.setUpdated_at(dateobj);
            
            empresaService.save(user);
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return user;
    }

    @GetMapping("/mostrar")
    public String mostrar() {
        //ModelAndView mav = new ModelAndView("/mostrar");
        List<Empresa> usuarios = empresaService.findAll();
        String b = "";
        for (Empresa a : usuarios) {
            b += "\n Nombre :" + a.getNombreEmpresa() + "\t ID: " + a.getId();
        }       
        
        return b;
    }
    @GetMapping("/update")
   public Empresa update(@PathParam("id") int id, @PathParam("nombre") String nombre) {
       Empresa user = new Empresa();
       if (empresaService.findById(id).toString() != "Optional.empty") {

           user.setId(id);

           user.setNombreEmpresa(nombre);
           Date dateobj = new Date(System.currentTimeMillis());
           user.setUpdated_at(dateobj);
           empresaService.update(user);
       }
       return user;
   }
}