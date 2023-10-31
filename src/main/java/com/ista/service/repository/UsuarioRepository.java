package com.ista.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ista.service.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("SELECT U FROM Usuario U WHERE U.email=:correo AND U.clave=:password")
    Optional<Usuario> login(String correo, String password);
}
