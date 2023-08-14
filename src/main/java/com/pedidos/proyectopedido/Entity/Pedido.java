package com.pedidos.proyectopedido.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido", nullable = false)
    private Integer idPedido;

    @Column(name = "costo_final", nullable = false)
    private Double costoFinal;

    @Column(name = "fecha_pedido", nullable = false)
    private Date fechaPedido;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Pedido() {
    }

    public Pedido(Integer idPedido, Double costoFinal, Date fechaPedido, Boolean estado) {
        this.idPedido = idPedido;
        this.costoFinal = costoFinal;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(Double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", costoFinal=" + costoFinal +
                ", fechaPedido=" + fechaPedido +
                ", estado=" + estado +
                '}';
    }
}
