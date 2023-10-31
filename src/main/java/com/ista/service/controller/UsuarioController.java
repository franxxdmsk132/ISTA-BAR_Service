package com.ista.service.controller;

import org.springframework.web.bind.annotation.*;

import com.ista.service.entity.Usuario;
import com.ista.service.entity.dto.LoginRequestDTO;
import com.ista.service.service.UsuarioService;
import com.ista.service.utlis.GenericResponse;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins=("http://localhost:4200"))

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("pass");
        return this.service.login(email, contrasenia);
    }
    @PostMapping
    public GenericResponse save(@RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }
    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @RequestBody Usuario u){
        return this.service.guardarUsuario(u);
    }
    @PostMapping("/loginSer")
    public GenericResponse<Usuario> login(@RequestBody LoginRequestDTO loginRequest) {
        String email = loginRequest.getEmail();
        String contrasenia = loginRequest.getPass();
        return this.service.login(email, contrasenia);
    }
}
