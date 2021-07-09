package com.basis.colatina.service.service;

import com.basis.colatina.service.domain.Anexo;
import com.basis.colatina.service.repository.AnexoRepository;
import com.basis.colatina.service.service.dto.AnexoDTO;
import com.basis.colatina.service.service.exception.RegraNegocioException;
import com.basis.colatina.service.service.feign.DocumentClient;
import com.basis.colatina.service.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AnexoService {
    
    private final AnexoRepository anexoRepository;
    
    private final AnexoMapper anexoMapper;

    private final DocumentClient documentClient;

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
        Anexo anexo = anexoMapper.toEntity(dto);
        anexo.setHash(documentClient.upload());
        anexoRepository.save(anexo);
        return anexoMapper.toDto(anexo);
    }

    public void excluir(Long id) {
        Anexo Anexo = get(id);
        anexoRepository.delete(Anexo);
    }
    
}
