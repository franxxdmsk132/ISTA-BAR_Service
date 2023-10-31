package com.ista.service.controller;

import com.ista.service.entity.Categoria;
import com.ista.service.entity.Cliente;
import com.ista.service.entity.dto.GenerarPedidoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ista.service.entity.dto.CategoriaDto;
import com.ista.service.entity.filters.CategoriaFilter;
import com.ista.service.service.CategoriaService;
import com.ista.service.utlis.GenericResponse;

import javax.validation.Valid;
@CrossOrigin(origins=("http://localhost:4200"))

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public GenericResponse listarCategoriasActivas() {
        return this.service.listarCategoriasActivas();
    }

    @PostMapping("/save")
    public GenericResponse save(@Valid @RequestBody Categoria c){
        return this.service.save(c);
    }

    @PostMapping("/filtrar")
    public ResponseEntity<Page<CategoriaDto>> filtrar(Pageable pageRequest, @Valid
    @RequestBody(required = false) CategoriaFilter filter) {
        return ResponseEntity.ok(this.service.findAll(pageRequest, filter));
    }
}
