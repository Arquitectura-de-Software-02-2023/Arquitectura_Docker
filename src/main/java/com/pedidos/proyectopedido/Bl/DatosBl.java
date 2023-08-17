package com.pedidos.proyectopedido.Bl;

import com.pedidos.proyectopedido.Dao.DatosRepository;
import com.pedidos.proyectopedido.Dao.TiposRepository;
import com.pedidos.proyectopedido.Dto.DatosDto;
import com.pedidos.proyectopedido.Dto.ResponseDto;
import com.pedidos.proyectopedido.Dto.TiposDto;
import com.pedidos.proyectopedido.Entity.Datos;
import com.pedidos.proyectopedido.Entity.Tipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatosBl {
    @Autowired
    private DatosRepository datosRepository;

    @Autowired
    private TiposRepository tiposRepository;

    @Autowired
    private ApiConsumerBl apiConsumerBl;

    // obtener todos los datos
    public List<DatosDto> getall() {
        List<DatosDto> datosDtos = new ArrayList<>();
        datosRepository.findAll().forEach(datos -> {
            DatosDto datosDto = new DatosDto();
            datosDto.setIdDato(datos.getIdDato());
            datosDto.setDato(datos.getDato());
            datosDto.setIdTipo(datos.getTipos().getIdTipo());
            datosDtos.add(datosDto);
        });
        return datosDtos;
    }

    //guardar un dato
    public void guardar(ResponseDto responseDto) {
        Datos datosDto1 = new Datos();
        Tipos tiposDto = new Tipos();
        tiposDto.setIdTipo(1);
        datosDto1.setDato(responseDto.getMensaje());
        datosDto1.setTipos(tiposDto);
        datosRepository.save(datosDto1);
    }

    //Modificar por id
    public void modificar(ResponseDto responseDto, Integer id) {
        Datos datosDto1 = new Datos();
        Tipos tiposDto = new Tipos();
        tiposDto.setIdTipo(1);
        datosDto1.setIdDato(id);
        datosDto1.setDato(responseDto.getMensaje());
        datosDto1.setTipos(tiposDto);
        datosRepository.save(datosDto1);
    }

    //Eliminar por id
    public void eliminar(Integer id) {
        datosRepository.deleteById(Long.valueOf(id));
    }


}
