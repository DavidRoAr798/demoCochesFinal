package com.example;

import javax.persistence.*;

@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matricula, marca, modelo;
    private Integer año;
    private Double precio;
    @ManyToOne //coche puede pertenecer a una persona
    private Persona propietario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Double getPrecio() {
        return precio;


    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "CocheService{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coche that = (Coche) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getMatricula() != null ? !getMatricula().equals(that.getMatricula()) : that.getMatricula() != null)
            return false;
        if (getMarca() != null ? !getMarca().equals(that.getMarca()) : that.getMarca() != null) return false;
        if (getModelo() != null ? !getModelo().equals(that.getModelo()) : that.getModelo() != null) return false;
        if (getAño() != null ? !getAño().equals(that.getAño()) : that.getAño() != null) return false;
        return getPrecio() != null ? getPrecio().equals(that.getPrecio()) : that.getPrecio() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
        result = 31 * result + (getMarca() != null ? getMarca().hashCode() : 0);
        result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
        result = 31 * result + (getAño() != null ? getAño().hashCode() : 0);
        result = 31 * result + (getPrecio() != null ? getPrecio().hashCode() : 0);
        return result;
    }
}
