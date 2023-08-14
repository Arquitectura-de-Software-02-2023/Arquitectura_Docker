package com.pedidos.proyectopedido.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu", nullable = false)
    private Integer idMenu;

    @Column(name = "nombre_plato", nullable = false)
    private String nombrePlato;

    @Column(name = "costo", nullable = false)
    private BigDecimal costo;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Menu() {
    }

    public Menu(Integer idMenu, String nombrePlato, BigDecimal costo, Boolean estado) {
        this.idMenu = idMenu;
        this.nombrePlato = nombrePlato;
        this.costo = costo;
        this.estado = estado;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", nombrePlato='" + nombrePlato + '\'' +
                ", costo=" + costo +
                ", estado=" + estado +
                '}';
    }
}

