package com.example.demo.models.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "email")
    @NotEmpty
    @Size(max = 100)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "contraseña")
    @NotEmpty
    private String contraseña;

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String pw) {
        this.contraseña = pw;
    }

    @Column(name = "nombre")
    @NotEmpty
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellidos")
    @NotEmpty
    private String apellidos;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Column(name = "created_at")
    private Date created_at;

    public Date getCreated() {
        return created_at;
    }

    public void setCreated(Date date) {
        this.created_at = date;
    }

    @Column(name = "updated_at")
    private Date updated_at;

    public Date getUpdated() {
        return updated_at;
    }

    public void setUpdated(Date date) {
        this.updated_at = date;
    }


}