package com.ista.service.service;

import com.ista.service.entity.Categoria;
import com.ista.service.entity.Platillo;
import org.springframework.stereotype.Service;

import com.ista.service.repository.PlatilloRepository;
import com.ista.service.utlis.GenericResponse;

import static com.ista.service.utlis.Global.*;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PlatilloService {
    private final PlatilloRepository repository;



    public PlatilloService(PlatilloRepository repository) {
        this.repository = repository;
    }
    public GenericResponse listarPlatillosRecomendados(){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listarPlatillosRecomendados());
    }
    // Método para devolver todos los detalles de los pedidos
//    public GenericResponse findAllDetalles(){
//        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.findAllDetalles());
//    }
    public GenericResponse listarPlatillosPorCategoria(int idC){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listarPlatillosPorCategoria(idC));
    }
    //Método para guardar y actualizar Platillo
    public GenericResponse save(Platillo c) {
        Optional<Platillo> opt = this.repository.findById(c.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        if (idf == 0) {
            if (repository.existsByNamePlatillo(c.getNombre().trim()) == 1) {
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Lo sentimos: " +
                        "Ya existe una categoria con ese mismo nombre, " +
                        "y si el problema persiste comuniquese con el soporte técnico", null);
            } else {
                //Guarda
                c.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Categoria registrada correctamente", this.repository.save(c));
            }

        }else{
            //Actualizar Registro
            if(repository.existsByNamePlatilloForUpdate(c.getNombre().trim(), c.getId()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Error: Ya existe una Categoria con esos mismos datos" +
                        "verifique e intente de nuevo", null);
            }else{
                //Actualiza
                c.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del cliente actualizado", this.repository.save(c));
            }
        }
    }
}
