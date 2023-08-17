package com.pedidos.proyectopedido.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos")
public class Tipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo", nullable = false)
    private Integer idTipo;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public Tipos() {
    }

    public Tipos(Integer idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipos{" +
                "idTipo=" + idTipo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
