package com.pedidos.proyectopedido.Bl;

import com.pedidos.proyectopedido.Dao.DatosRepository;
import com.pedidos.proyectopedido.Dao.TiposRepository;
import com.pedidos.proyectopedido.Dto.DatosDto;
import com.pedidos.proyectopedido.Dto.ResponseDto;
import com.pedidos.proyectopedido.Dto.TiposDto;
import com.pedidos.proyectopedido.Entity.Datos;
import com.pedidos.proyectopedido.Entity.Tipos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatosBl {

    private static final Logger logger = LoggerFactory.getLogger(DatosBl.class);

    @Autowired
    private DatosRepository datosRepository;

    @Autowired
    private TiposRepository tiposRepository;

    @Autowired
    private ApiConsumerBl apiConsumerBl;

    public List<DatosDto> getall() {
        logger.info("Fetching all datos from the database.");

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

    public void guardar(ResponseDto responseDto) {
        logger.info("Saving a new dato.");

        Datos datosDto1 = new Datos();
        Tipos tiposDto = new Tipos();
        tiposDto.setIdTipo(1);
        datosDto1.setDato(responseDto.getMensaje());
        datosDto1.setTipos(tiposDto);
        datosRepository.save(datosDto1);
    }

    public void modificar(ResponseDto responseDto, Integer id) {
        logger.info("Updating dato with ID: " + id);

        Datos datosDto1 = new Datos();
        Tipos tiposDto = new Tipos();
        tiposDto.setIdTipo(1);
        datosDto1.setIdDato(id);
        datosDto1.setDato(responseDto.getMensaje());
        datosDto1.setTipos(tiposDto);
        datosRepository.save(datosDto1);
    }

    public void eliminar(Integer id) {
        logger.info("Deleting dato with ID: " + id);

        datosRepository.deleteById(Long.valueOf(id));
    }
}
