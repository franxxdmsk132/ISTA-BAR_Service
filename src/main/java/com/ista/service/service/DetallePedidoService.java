package com.ista.service.service;

import com.ista.service.utlis.GenericResponse;
import org.springframework.stereotype.Service;

import com.ista.service.entity.DetallePedido;
import com.ista.service.repository.DetallePedidoRepository;

import javax.transaction.Transactional;
import java.util.List;

import static com.ista.service.utlis.Global.*;

@Service
@Transactional
public class DetallePedidoService {
    private final DetallePedidoRepository repository;
    // Método para devolver todos los detalles de los pedidos
    public GenericResponse findAllDetalles(){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.findAllDetalles());
    }
    public DetallePedidoService(DetallePedidoRepository repository) {

        this.repository = repository;
    }
    //Método para guardar detalles del pedido
    public void guardarDetalles(Iterable<DetallePedido> detalle){
        this.repository.saveAll(detalle);
    }

}
