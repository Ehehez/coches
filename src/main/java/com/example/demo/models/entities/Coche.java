package com.example.demo.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="coche")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "Color")
    private String color;

    @Column(name = "Id Empresa")
    @NotEmpty
    private int empresaId;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the empresaId
     */
    public int getEmpresaId() {
        return empresaId;
    }

    /**
     * @param empresaId the empresaId to set
     */
    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresaId", nullable = false)
    private Empresa empresa;

}