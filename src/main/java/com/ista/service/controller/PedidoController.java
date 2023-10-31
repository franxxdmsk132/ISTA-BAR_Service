package com.ista.service.controller;

import com.ista.service.entity.DetallePedido;
import com.ista.service.entity.Pedido;
import com.ista.service.entity.dto.PedidoCompletoDTO;
import com.ista.service.repository.PedidoRepository;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ista.service.entity.dto.GenerarPedidoDTO;
import com.ista.service.entity.dto.PedidoConDetallesDTO;
import com.ista.service.service.PedidoService;
import com.ista.service.utlis.GenericResponse;

import java.util.List;

import static com.ista.service.utlis.Global.*;

@CrossOrigin(origins = ("http://localhost:4200"))

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }


    @GetMapping("/listarpe")
    public GenericResponse listarPedidos() {
        return this.service.listarPedidos();
    }


    //listarDetalle pedidos
    @GetMapping//("/detallespedidos")
    public List<DetallePedido> findAllDetallesPedidos() {
        return this.service.findAllDetallesPedidos();
    }


    //
    @GetMapping("/listars")
    public GenericResponse<List<PedidoConDetallesDTO>> devolverPedidoConDetalle() {
        return this.service.devolverPedidoConDetalle();
    }
    //

    //LISTAR PEDIDOS CON DETALLES
    @GetMapping("/misPedidos/{idCli}")
    public GenericResponse<List<PedidoConDetallesDTO>> devolverMisComprasConDetalle(@PathVariable int idCli) {
        return this.service.devolverMisCompras(idCli);
    }

    //GUARDAR PEDIDO
    @PostMapping
    public GenericResponse guardarPedido(@RequestBody GenerarPedidoDTO dto) {
        return this.service.guardarPedido(dto);
    }

    //ANULAR PEDIDO
    @DeleteMapping("/{id}")
    public GenericResponse anularPedido(@PathVariable int id) {
        return this.service.anularPedido(id);
    }

    //EXPORTAR PDF DE ORDEN
    @GetMapping("exportInvoice")
    public ResponseEntity<Resource> exportInvoice(@RequestParam int idCli, @RequestParam int idOrden) {
        return this.service.exportInvoice(idCli, idOrden);
    }

    // NUEVO MÉTODO PARA LISTAR PEDIDOS CON SU DETALLE Y CLIENTE
    @GetMapping("/pedidos-con-detalle-y-cliente")
    public GenericResponse<List<PedidoCompletoDTO>> listarPedidosConDetalleYCliente() {
        return this.service.listarPedidosConDetalleYCliente();
    }
}
