package com.basis.colatina.service.service.mapper;

import com.basis.colatina.service.domain.elasticsearch.TarefaDocument;
import com.basis.colatina.service.service.dto.TarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaListMapper extends EntityMapper<TarefaDTO, TarefaDocument> {

}
