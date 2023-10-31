package com.ista.service.spec;

import org.springframework.data.jpa.domain.Specification;

import com.ista.service.entity.Categoria;
import com.ista.service.entity.filters.CategoriaFilter;

public interface CategoriaSpec {
    Specification<Categoria> filtrar (CategoriaFilter filter);
}
