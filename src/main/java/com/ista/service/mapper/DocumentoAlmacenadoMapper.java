package com.ista.service.mapper;

import org.mapstruct.Mapper;

import com.ista.service.entity.DocumentoAlmacenado;
import com.ista.service.entity.dto.DocumentoAlmacenadoDto;
import com.ista.service.mapperImpl.GenericMapper;

@Mapper(componentModel = "spring")
public interface DocumentoAlmacenadoMapper extends GenericMapper<DocumentoAlmacenadoDto, DocumentoAlmacenado> {
    @Override
    DocumentoAlmacenadoDto toDto(DocumentoAlmacenado documentoAlmacenado);
    @Override
    DocumentoAlmacenado toEntity(DocumentoAlmacenadoDto documentoAlmacenadoDto);
}
