package com.ista.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ista.service.entity.DetallePedido;

import static org.hibernate.loader.Loader.SELECT;

public interface DetallePedidoRepository extends CrudRepository<DetallePedido, Integer> {
    @Query("SELECT DP FROM DetallePedido DP WHERE DP.pedido.id=:idP")
    Iterable<DetallePedido> findByPedido(int idP);

    @Query("SELECT DP FROM DetallePedido DP ")
    Iterable<DetallePedido> findAllDetalles();

    @Query(value = "SELECT SUM(dp.cantidad * dp.precio) AS \"Total\" FROM detalle_pedido dp JOIN pedido p\n"
        + "ON p.id = dp.pedido_id\n"
        + "WHERE p.cliente_id = :idCli AND p.anular_pedido = 0", nativeQuery = true)
    Double totalByIdCustomer(int idCli);
}
