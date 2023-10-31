package com.ista.service.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ista.service.entity.Platillo;

public interface PlatilloRepository extends CrudRepository<Platillo, Integer> {
    @Query("SELECT P FROM Platillo P WHERE P.recomendado IS 1")
    Iterable<Platillo> listarPlatillosRecomendados();

    @Query("SELECT P FROM Platillo P WHERE P.categoria.id=:idC")
    Iterable<Platillo> listarPlatillosPorCategoria(int idC);

    @Query(value = "(select EXISTS(SELECT id FROM Platillo  where nombre=:nombre))" , nativeQuery = true)
    int existsByNamePlatillo (String nombre);

    @Query(value = "(select EXISTS(SELECT P.* FROM Platillo P  where P.nombre=:nombre and not (P.id=:id)))" , nativeQuery = true)
    int existsByNamePlatilloForUpdate (String nombre ,int id);

    @Modifying
    @Query("UPDATE Platillo P SET P.stock=stock-:cant WHERE P.id=:id")
    void descontarStock(int cant, int id);

    @Modifying
    @Query("UPDATE Platillo P SET P.stock=stock+:cant WHERE P.id=:id")
    void aumentarStock(int cant, int id);
}
