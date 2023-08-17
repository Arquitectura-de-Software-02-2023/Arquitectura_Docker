package com.pedidos.proyectopedido.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "datos")
public class Datos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dato", nullable = false)
    private Integer idDato;

    @Column(name = "dato", nullable = false)
    private String dato;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipos tipos;

    public Datos() {
    }

    public Datos(Integer idDato, String dato, Tipos tipos) {
        this.idDato = idDato;
        this.dato = dato;
        this.tipos = tipos;
    }

    public Integer getIdDato() {
        return idDato;
    }

    public void setIdDato(Integer idDato) {
        this.idDato = idDato;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }

    @Override
    public String toString() {
        return "DatosEntity{" +
                "idDato=" + idDato +
                ", dato='" + dato + '\'' +
                ", tipos=" + tipos +
                '}';
    }
}
