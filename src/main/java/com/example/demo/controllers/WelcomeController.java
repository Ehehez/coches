package com.example.demo.controllers;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.models.dao.UsuarioDAO;
import com.example.demo.models.entities.Usuario;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@CrossOrigin(origins = { "*" })
/*@RestController*/
@RequestMapping(value = "aaa", produces = { "application/json" })
class WelcomeController {


    private UsuarioDAO user;

    @GetMapping("/")
    public String welcome() {
        return "123";
    }

    @GetMapping("/buscar")
    public String buscar(){
        
        Usuario userr = user.findOne(1);
        if (userr != null){
        return userr.getNombre();
        } else return "es null";
    }

    
    
    @GetMapping("/prueba")
    public String dbExists() {
        String exist = "false";
        try {
            Connection conn = null;
            Statement st = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresas", "root", "conexiona");
            st = (Statement) conn.createStatement();
            String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'empresas'";
            ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);

            if (rs.next()) {
                //JOptionPane.showMessageDialog(main, "La base de datos existe.");
                exist = "true";
            }
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(main, "La base de datos no existe.");
            exist = ex.toString();
        }
        return exist;
    }
}