package com.ista.service.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ista.service.entity.Cliente;
import com.ista.service.entity.DetallePedido;
import com.ista.service.entity.Pedido;

public class GenerarPedidoDTO {
    private Pedido pedido;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Iterable<DetallePedido> detallePedidos;
    private Cliente cliente;

    public GenerarPedidoDTO() {
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Iterable<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(Iterable<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
