package com.basis.colatina.service.service.mapper;

import com.basis.colatina.service.domain.Anexo;
import com.basis.colatina.service.service.dto.AnexoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnexoMapper extends EntityMapper<AnexoDTO, Anexo> {
}
