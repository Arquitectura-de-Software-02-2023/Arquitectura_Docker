package com.pedidos.proyectopedido.Dao;

import com.pedidos.proyectopedido.Entity.Datos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DatosRepository extends JpaRepository<Datos, Long> {

}
