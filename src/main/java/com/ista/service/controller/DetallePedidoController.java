package com.ista.service.controller;

import com.ista.service.service.DetallePedidoService;
import com.ista.service.utlis.GenericResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins=("http://localhost:4200"))
@RestController
@RequestMapping("api/detalles")
public class DetallePedidoController {

    private final DetallePedidoService service;

    public DetallePedidoController(DetallePedidoService service) {this.service = service;}

    @GetMapping("/listar")
    public GenericResponse findfindAllDetalles(){
        return this.service.findAllDetalles();
    }

}
