package com.basis.colatina.service.service.mapper;

import com.basis.colatina.service.domain.Anexo;
import com.basis.colatina.service.service.dto.AnexoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnexoMapper extends EntityMapper<AnexoDTO, Anexo> {

    @Override
    @Mapping(source = "idTarefa", target = "tarefa.id")
    Anexo toEntity(AnexoDTO dto);

    @Override
    @InheritInverseConfiguration
    AnexoDTO toDto(Anexo entity);
}
