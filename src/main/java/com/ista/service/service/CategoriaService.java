package com.ista.service.service;

import com.ista.service.entity.Cliente;
import com.ista.service.entity.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ista.service.entity.Categoria;
import com.ista.service.entity.dto.CategoriaDto;
import com.ista.service.entity.filters.CategoriaFilter;
import com.ista.service.mapper.CategoriaMapper;
import com.ista.service.repository.CategoriaRepository;
import com.ista.service.spec.CategoriaSpec;
import com.ista.service.utlis.GenericResponse;

import org.springframework.data.domain.Sort.Order;

import javax.transaction.Transactional;

import static com.ista.service.utlis.Global.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaService {
    private final CategoriaRepository repository;
    private final CategoriaSpec spec;
    private final CategoriaMapper mapper;


    public CategoriaService(CategoriaRepository repository, CategoriaSpec spec, CategoriaMapper mapper ) {
        this.repository = repository;
        this.spec = spec;
        this.mapper = mapper;
    }

    public GenericResponse listarCategoriasActivas() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listarCategoriasActivas());
    }

    //Método para guardar y actualizar Categoria
    public GenericResponse save(Categoria c) {
        Optional<Categoria> opt = this.repository.findById(c.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        if (idf == 0) {
            if (repository.existsByName(c.getNombre().trim()) == 1) {
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
            if(repository.existsByNomForUpdate(c.getNombre().trim(), c.getId()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Error: Ya existe una Categoria con esos mismos datos" +
                        "verifique e intente de nuevo", null);
            }else{
                //Actualiza
                c.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del cliente actualizado", this.repository.save(c));
            }
        }
    }


    public Page<CategoriaDto> findAll(Pageable page, CategoriaFilter filter) {
        // Comprobamos si existe orden, sino ponenemos el generico.
        if (page.getSort() == null) {
            List<Order> listaOrden = new ArrayList<>();
            listaOrden.add(new Order(Sort.Direction.ASC, Categoria.C_NOMBRE));
            Sort sort = Sort.by(listaOrden);
            page = PageRequest.of(page.getPageNumber(), page.getPageSize(), sort);
        }
        Page<Categoria> lista = repository.findAll(spec.filtrar(filter), page);
        return mapper.toDto(lista);
    }

}
