package com.pedidos.proyectopedido.Bl;

import com.pedidos.proyectopedido.Dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApiConsumerBl {

    private static final Logger logger = LoggerFactory.getLogger(ApiConsumerBl.class);

    @Value("${apiDatos.url}")
    private String url;

    public List<ResponseDto> getFacts() {
        logger.info("Fetching facts from the API.");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map[]> responseEntity = restTemplate.getForEntity(url, Map[].class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<ResponseDto> responseDtos = new ArrayList<>();

            for (Map<String, Object> entry : responseEntity.getBody()) {
                String text = (String) entry.get("title");
                ResponseDto responseDto = new ResponseDto();
                responseDto.setMensaje(text);
                responseDtos.add(responseDto);
            }
            logger.info("Facts retrieved successfully.");
            return responseDtos;
        } else {
            logger.error("Failed to retrieve facts from the API.");
            throw new RuntimeException("No se pudo obtener los datos de la API");
        }
    }
}
