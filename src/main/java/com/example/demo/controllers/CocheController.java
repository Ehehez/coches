package com.example.demo.controllers;

import java.sql.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.models.entities.Coche;
import com.example.demo.models.entities.Empresa;
import com.example.demo.models.services.CocheService;
import com.example.demo.models.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coches")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/crear")
    public Coche save(@PathParam("marca") String marca, @PathParam("modelo") String modelo,
            @PathParam("color") String color, @PathParam("idempresa") int idempresa) {
        Coche user = null;

        try {
            if (empresaService.findById(idempresa).toString() != "Optional.empty") {
                user = new Coche();
                
                user.setModelo(modelo);
                user.setColor(color);
                user.setEmpresaId(idempresa);
                user.setMarca(marca);
                
                cocheService.save(user);
                
            }

        } catch (Exception ex) {
            System.out.println("a");
            System.out.println(ex.toString());
        }
        return user;
    }

    @GetMapping("/mostrar")
    public String mostrar() {

        List<Coche> usuarios = cocheService.findAll();
        String b = "";
        for (Coche a : usuarios) {
            b += "\n Modelo :" + a.getModelo() + "\t ID: " + a.getId();
        }

        return b;
    }

    @GetMapping("/update")
    public Coche update(@PathParam("id") int id, @PathParam("marca") String marca, @PathParam("modelo") String modelo,
            @PathParam("color") String color, @PathParam("idempresa") int idempresa) {
        Coche user = null;
        if (cocheService.findById(id).toString() != "Optional.empty") {

            if (empresaService.findById(idempresa).toString() != "Optional.empty") {
                user = new Coche();
                user.setId(id);
                user.setModelo(modelo);
                user.setColor(color);
                user.setEmpresaId(idempresa);
                user.setMarca(marca);

                cocheService.save(user);
            }
        }
        return user;
    }
}