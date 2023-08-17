package com.pedidos.proyectopedido.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiposDao {
    @Autowired
    private TiposRepository tiposRepository;
}
