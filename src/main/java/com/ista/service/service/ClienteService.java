package com.ista.service.service;

import org.springframework.stereotype.Service;

import com.ista.service.entity.Cliente;
import com.ista.service.repository.ClienteRepository;
import com.ista.service.utlis.GenericResponse;

import javax.transaction.Transactional;

import static com.ista.service.utlis.Global.*;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {
    private final ClienteRepository repository;


    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }


    // Método para listar todos los clientes
    public GenericResponse listarClientes(){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.findAll());
    }
    //Método para guardar y actualizar cliente
    public GenericResponse save(Cliente c){
        Optional<Cliente> opt = this.repository.findById(c.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        if(idf == 0){
            if(repository.existByDoc(c.getNumDoc().trim()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Lo sentimos: " +
                        "Ya existe un cliente con ese mismo numero de documento, " +
                        "y si el problema persiste comuniquese con el soporte técnico", null);
            }else{
                //Guarda
                c.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Categoria registrada correctamente", this.repository.save(c));
            }
        }else{
            //Actualizar Registro
            if(repository.existByDocForUpdate(c.getNumDoc().trim(), c.getId()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Error: Ya existe un cliente con esos mismos datos" +
                        "verifique e intente de nuevo", null);
            }else{
                //Actualiza
                c.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del cliente actualizado", this.repository.save(c));
            }
        }
    }

}
