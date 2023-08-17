package com.pedidos.proyectopedido.Bl;

import com.pedidos.proyectopedido.Dao.TiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiposBl {

    @Autowired
    private TiposRepository tiposRepository;

}
