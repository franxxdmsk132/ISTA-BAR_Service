package com.ista.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ista.service.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>, JpaSpecificationExecutor<Categoria> {
    @Query("SELECT C FROM Categoria C WHERE C.vigencia IS 1")
    Iterable<Categoria> listarCategoriasActivas();

    @Query(value = "(SELECT EXISTS(SELECT id FROM CATEGORIA where nombre=:nombre))",nativeQuery = true)
    int existsByName  (String nombre);

    @Query(value = "SELECT EXISTS (SELECT C.* FROM Categoria C WHERE C.nombre=:nombre  and not (c.id=:id))", nativeQuery = true)
    int existsByNomForUpdate (String nombre,int id);



}
