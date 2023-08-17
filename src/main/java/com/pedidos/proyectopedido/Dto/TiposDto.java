package com.pedidos.proyectopedido.Dto;

public class TiposDto {
    private Integer idTipo;
    private String tipo;

    public TiposDto() {
    }

    public TiposDto(Integer idTipo, String tipo) {
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
        return "TiposDto{" +
                "idTipo=" + idTipo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
