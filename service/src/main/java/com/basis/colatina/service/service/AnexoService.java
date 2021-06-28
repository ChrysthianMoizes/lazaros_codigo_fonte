package com.basis.colatina.service.service;

import com.basis.colatina.service.domain.Anexo;
import com.basis.colatina.service.repository.AnexoRepository;
import com.basis.colatina.service.service.dto.AnexoDTO;
import com.basis.colatina.service.service.exception.RegraNegocioException;
import com.basis.colatina.service.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnexoService {
    
    private final AnexoRepository anexoRepository;
    
    private final AnexoMapper anexoMapper;

    public List<AnexoDTO> listar() {
        List<Anexo> responsaveis = anexoRepository.findAll();
        return anexoMapper.toDto(responsaveis);
    }

    public AnexoDTO obterPorId(Long id) {
        Anexo usuario = get(id);
        return anexoMapper.toDto(usuario);
    }

    private Anexo get(Long id) {
        return anexoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Anexo não encontrado"));
    }

    public AnexoDTO salvar(AnexoDTO dto) {
        Anexo Anexo = anexoMapper.toEntity(dto);
        anexoRepository.save(Anexo);
        return anexoMapper.toDto(Anexo);
    }

    public void excluir(Long id) {
        Anexo Anexo = get(id);
        anexoRepository.delete(Anexo);
    }
    
}
