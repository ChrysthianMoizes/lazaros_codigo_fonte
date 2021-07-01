package com.basis.colatina.service.service.mapper;

import com.basis.colatina.service.domain.Tarefa;
import com.basis.colatina.service.service.dto.TarefaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {

    @Override
    @Mapping(source = "idResponsavel", target = "responsavel.id")
    Tarefa toEntity(TarefaDTO dto);

    @Override
    @InheritInverseConfiguration
    TarefaDTO toDto(Tarefa entity);
}
