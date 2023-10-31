package com.ista.service.specImpl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.ista.service.entity.Categoria;
import com.ista.service.entity.filters.CategoriaFilter;
import com.ista.service.spec.CategoriaSpec;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaSpecImpl extends AbstractSpec implements CategoriaSpec {
    @Override
    public Specification<Categoria> filtrar(CategoriaFilter filter) {
        return ((root, query, cb) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (filter.getVerInactivos() == null || filter.getVerInactivos().equals("NO")) {
                conditions.add(cb.equal(root.get(Categoria.C_VIGENCIA), 1));
            }
            if (filter.getNombre() != null) {
                conditions.add(like(cb, root.get(Categoria.C_NOMBRE), filter.getNombre()));
            }
            return and(cb, conditions);
        });
    }
}
