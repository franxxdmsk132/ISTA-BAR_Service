package com.ista.service.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ista.service.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
    @Query("SELECT P FROM Pedido P WHERE P.cliente.id=:idCli")
    Iterable<Pedido> devolverMisCompras(int idCli);
    @Query("SELECT P FROM Pedido P WHERE P.id=:idOrden AND P.cliente.id=:idCli")
    Optional<Pedido> findByIdAndClienteId(int idCli, int idOrden);

}
