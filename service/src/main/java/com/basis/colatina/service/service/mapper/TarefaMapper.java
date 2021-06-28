package com.basis.colatina.service.service.mapper;

import com.basis.colatina.service.domain.Tarefa;
import com.basis.colatina.service.service.dto.TarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {
}
