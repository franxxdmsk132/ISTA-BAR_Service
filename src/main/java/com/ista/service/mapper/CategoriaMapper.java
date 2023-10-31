package com.ista.service.mapper;

import org.mapstruct.Mapper;

import com.ista.service.entity.Categoria;
import com.ista.service.entity.dto.CategoriaDto;
import com.ista.service.mapperImpl.GenericMapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends GenericMapper<CategoriaDto, Categoria> {
    @Override
    CategoriaDto toDto(Categoria categoria);
    @Override
    Categoria toEntity(CategoriaDto categoriaDto);
}
