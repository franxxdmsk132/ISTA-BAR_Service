package com.ista.service.repository;

import com.ista.service.entity.Categoria;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ista.service.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {

    @Query("SELECT C FROM Cliente C")
    Iterable<Cliente> findAll();
    @Query(value = "(SELECT EXISTS(SELECT id FROM cliente WHERE num_doc=:dni))", nativeQuery = true)
    int existByDoc(String dni);
    @Query(value = "SELECT EXISTS(SELECT C.* FROM cliente C WHERE C.num_doc=:dni AND NOT (C.id=:id))", nativeQuery = true)
    int existByDocForUpdate(String dni, int id);
}
