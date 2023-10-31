package com.ista.service.controller;

import com.ista.service.entity.Platillo;
import org.springframework.web.bind.annotation.*;

import com.ista.service.service.PlatilloService;
import com.ista.service.utlis.GenericResponse;

import javax.validation.Valid;

@CrossOrigin(origins=("http://localhost:4200"))

@RestController
@RequestMapping("api/platillo")
public class PlatilloController {
    private final PlatilloService service;

    public PlatilloController(PlatilloService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public GenericResponse save(@Valid @RequestBody Platillo p){
        return this.service.save(p);
    }

    @GetMapping
    public GenericResponse listarPlatillosRecomendados(){
        return this.service.listarPlatillosRecomendados();
    }

    @GetMapping("/{idC}")
    public GenericResponse listarPlatillosPorCategoria(@PathVariable int idC){
        return this.service.listarPlatillosPorCategoria(idC);
    }
    @GetMapping("/lista")
    public GenericResponse listarPlatillosRecomendados1(){
        return this.service.listarPlatillosRecomendados();
    }
}
