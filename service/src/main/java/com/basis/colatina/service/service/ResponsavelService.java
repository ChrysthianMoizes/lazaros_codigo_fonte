package com.basis.colatina.service.service;

import com.basis.colatina.service.domain.Responsavel;
import com.basis.colatina.service.repository.ResponsavelRepository;
import com.basis.colatina.service.service.dto.ResponsavelDTO;
import com.basis.colatina.service.service.exception.RegraNegocioException;
import com.basis.colatina.service.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ResponsavelService {
    
    private final ResponsavelRepository responsavelRepository;

    private final ResponsavelMapper responsavelMapper;

    public List<ResponsavelDTO> listar() {
        List<Responsavel> responsaveis = responsavelRepository.findAll();
        return responsavelMapper.toDto(responsaveis);
    }

    public ResponsavelDTO obterPorId(Long id) {
        Responsavel usuario = get(id);
        return responsavelMapper.toDto(usuario);
    }

    private Responsavel get(Long id) {
        return responsavelRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Responsável nao encontrado"));
    }

    public ResponsavelDTO salvar(ResponsavelDTO dto) {
        Responsavel responsavel = responsavelMapper.toEntity(dto);
        responsavelRepository.save(responsavel);
        return responsavelMapper.toDto(responsavel);
    }

    public void excluir(Long id) {
        Responsavel responsavel = get(id);
        responsavelRepository.delete(responsavel);
    }
    
}
