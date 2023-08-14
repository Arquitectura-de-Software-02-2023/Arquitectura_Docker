package com.pedidos.proyectopedido.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu_pedido")
public class MenuPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_pedido", nullable = false)
    private Integer idMenuPedido;

    @ManyToOne
    @JoinColumn(name = "menu_id_menu", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "pedido_id_pedido", nullable = false)
    private Pedido pedido;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    public MenuPedido() {
    }

    public MenuPedido(Integer idMenuPedido, Menu menu, Pedido pedido, Integer cantidad, BigDecimal precioUnitario) {
        this.idMenuPedido = idMenuPedido;
        this.menu = menu;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Integer getIdMenuPedido() {
        return idMenuPedido;
    }

    public void setIdMenuPedido(Integer idMenuPedido) {
        this.idMenuPedido = idMenuPedido;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "MenuPedido{" +
                "idMenuPedido=" + idMenuPedido +
                ", menu=" + menu +
                ", pedido=" + pedido +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}

