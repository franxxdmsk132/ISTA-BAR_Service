package com.ista.service.entity.dto;

import com.ista.service.entity.Cliente;
import com.ista.service.entity.DetallePedido;
import com.ista.service.entity.Pedido;

import java.util.List;

public class PedidoCompletoDTO {
    private Pedido pedido;
    private Cliente cliente;
    private List<DetallePedido> detallePedidos;

    public PedidoCompletoDTO(Pedido pedido, Cliente cliente, Iterable<DetallePedido> detallePedidos) {
        this.pedido = pedido;
        this.cliente = cliente;
        this.detallePedidos = (List<DetallePedido>) detallePedidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
}

