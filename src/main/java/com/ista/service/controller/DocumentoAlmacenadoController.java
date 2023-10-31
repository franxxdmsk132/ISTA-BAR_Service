package com.ista.service.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ista.service.entity.DocumentoAlmacenado;
import com.ista.service.service.DocumentoAlmacenadoService;
import com.ista.service.utlis.GenericResponse;

import javax.servlet.http.HttpServletRequest;
@CrossOrigin(origins=("http://localhost:4200"))

@RestController
@RequestMapping("api/documento-almacenado")
public class DocumentoAlmacenadoController {
    private DocumentoAlmacenadoService service;

    public DocumentoAlmacenadoController(DocumentoAlmacenadoService service) {
        this.service = service;
    }

    @GetMapping
    public GenericResponse list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable String fileName, HttpServletRequest request) {
        return service.downloadByFileName(fileName, request);
    }

    @PostMapping
    public GenericResponse save(@ModelAttribute DocumentoAlmacenado obj) {
        return service.save(obj);
    }

    public GenericResponse update(Long aLong, DocumentoAlmacenado obj) {
        return null;
    }
    
    public GenericResponse delete(Long aLong) {
        return null;
    }
}
