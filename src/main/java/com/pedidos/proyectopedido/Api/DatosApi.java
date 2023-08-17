package com.pedidos.proyectopedido.Api;

import com.pedidos.proyectopedido.Bl.ApiConsumerBl;
import com.pedidos.proyectopedido.Bl.DatosBl;
import com.pedidos.proyectopedido.Dto.DatosDto;
import com.pedidos.proyectopedido.Dto.MessageDto;
import com.pedidos.proyectopedido.Dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/datos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class DatosApi {

    private static final Logger logger = LoggerFactory.getLogger(DatosApi.class);

    @Autowired
    private DatosBl datosBl;

    @Autowired
    private ApiConsumerBl apiConsumerBl;

    @GetMapping("/")
    public ResponseEntity<MessageDto<List<ResponseDto>>> getDatosCuriosos() {
        logger.info("Received request to get datos curiosos.");

        try {
            List<ResponseDto> responseDtoList = apiConsumerBl.getFacts();
            logger.info("Datos curiosos retrieved successfully.");
            return ResponseEntity.ok(new MessageDto<>(200, responseDtoList, "Datos retrieved successfully"));
        } catch (Exception e) {
            logger.error("Error while retrieving datos curiosos.", e);
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }

    @GetMapping("/user/")
    public ResponseEntity<MessageDto<List<DatosDto>>> getDatosCuriososUser(@RequestHeader("Authorization") String token) {
        logger.info("Received request to get datos curiosos for user.");

        try {
            List<DatosDto> responseDtoList = datosBl.getall();
            logger.info("Datos curiosos for user retrieved successfully.");
            return ResponseEntity.ok(new MessageDto<>(200, responseDtoList, "Datos retrieved successfully"));
        } catch (Exception e) {
            logger.error("Error while retrieving datos curiosos for user.", e);
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }

    @PostMapping("/")
    public ResponseEntity<MessageDto<ResponseDto>> saveDatosCuriosos(@RequestBody ResponseDto responseDto) {
        logger.info("Received request to save datos curiosos.");

        try {
            datosBl.guardar(responseDto);
            logger.info("Datos curiosos saved successfully.");
            return ResponseEntity.ok(new MessageDto<>(200, null, "Datos retrieved successfully"));
        } catch (Exception e) {
            logger.error("Error while saving datos curiosos.", e);
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto<ResponseDto>> updateDatosCuriosos(@RequestBody ResponseDto responseDto, @PathVariable int id) {
        logger.info("Received request to update datos curiosos with id: " + id);

        try {
            datosBl.modificar(responseDto, id);
            logger.info("Datos curiosos updated successfully.");
            return ResponseEntity.ok(new MessageDto<>(200, null, "Datos retrieved successfully"));
        } catch (Exception e) {
            logger.error("Error while updating datos curiosos.", e);
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto<ResponseDto>> deleteDatosCuriosos(@PathVariable int id) {
        logger.info("Received request to delete datos curiosos with id: " + id);

        try {
            datosBl.eliminar(id);
            logger.info("Datos curiosos deleted successfully.");
            return ResponseEntity.ok(new MessageDto<>(200, null, "Datos retrieved successfully"));
        } catch (Exception e) {
            logger.error("Error while deleting datos curiosos.", e);
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }
}
