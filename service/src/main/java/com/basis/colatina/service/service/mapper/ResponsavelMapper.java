package com.basis.colatina.service.service.mapper;

import com.basis.colatina.service.domain.Responsavel;
import com.basis.colatina.service.service.dto.ResponsavelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper extends EntityMapper<ResponsavelDTO, Responsavel> {
}
