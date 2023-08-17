package com.pedidos.proyectopedido.Bl;

import com.pedidos.proyectopedido.Dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApiConsumerBl {
    private final String url = "https://cat-fact.herokuapp.com/facts";

    public List<ResponseDto> getFacts() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map[]> responseEntity = restTemplate.getForEntity(url, Map[].class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<ResponseDto> responseDtos = new ArrayList<>();

            for (Map<String, Object> entry : responseEntity.getBody()) {
                String text = (String) entry.get("text");
                ResponseDto responseDto = new ResponseDto();
                responseDto.setMensaje(text);
                responseDtos.add(responseDto);
            }
            System.out.println(responseDtos);
            return responseDtos;
        } else {
            // Manejar el caso de respuesta de error según sea necesario
            throw new RuntimeException("No se pudo obtener los datos de la API");
        }
    }
}
