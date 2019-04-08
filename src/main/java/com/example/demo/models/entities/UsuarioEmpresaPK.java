package com.example.demo.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class UsuarioEmpresaPK implements Serializable{

    @Column(name = "Usuario_ID")
    private int usuarioid;

    @Column(name = "Empresa_ID")
    private int empresaid;
}