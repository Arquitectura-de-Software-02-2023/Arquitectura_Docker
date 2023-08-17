package com.pedidos.proyectopedido.Api;

import com.pedidos.proyectopedido.Bl.ApiConsumerBl;
import com.pedidos.proyectopedido.Bl.DatosBl;
import com.pedidos.proyectopedido.Dto.DatosDto;
import com.pedidos.proyectopedido.Dto.MessageDto;
import com.pedidos.proyectopedido.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/datos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DatosApi {

    @Autowired
    private DatosBl datosBl;

    @Autowired
    private ApiConsumerBl apiConsumerBl;

    @GetMapping("/")
    public ResponseEntity<MessageDto<List<ResponseDto>>> getDatosCuriosos(){
        List<ResponseDto> responseDtoList = apiConsumerBl.getFacts();
        System.out.println("enviado "+responseDtoList);
        try {
            return ResponseEntity.ok(new MessageDto<>(200, responseDtoList, "Datos retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }

    //obtener los datos por usuario
    @GetMapping("/user/")
    public ResponseEntity<MessageDto<List<DatosDto>>> getDatosCuriososUser(@RequestHeader("Authorization") String token){
        List<DatosDto> responseDtoList = datosBl.getall();
        System.out.println("enviado "+responseDtoList);
        try {
            return ResponseEntity.ok(new MessageDto<>(200, responseDtoList, "Datos retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }

    //guardar un dato curioso
    @PostMapping("/")
    public ResponseEntity<MessageDto<ResponseDto>> saveDatosCuriosos(@RequestBody ResponseDto responseDto){
        datosBl.guardar(responseDto);
        try {
            return ResponseEntity.ok(new MessageDto<>(200, null, "Datos retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }

    //modificar por id
    @PutMapping("/{id}")
    public ResponseEntity<MessageDto<ResponseDto>> updateDatosCuriosos(@RequestBody ResponseDto responseDto, @PathVariable int id){
        datosBl.modificar(responseDto, id);
        try {
            return ResponseEntity.ok(new MessageDto<>(200, null, "Datos retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }

    //eliminar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto<ResponseDto>> deleteDatosCuriosos(@PathVariable int id){
        datosBl.eliminar(id);
        try {
            return ResponseEntity.ok(new MessageDto<>(200, null, "Datos retrieved successfully"));
        } catch (Exception e) {
            return ResponseEntity.ok(new MessageDto<>(500, null, "error"));
        }
    }


}
