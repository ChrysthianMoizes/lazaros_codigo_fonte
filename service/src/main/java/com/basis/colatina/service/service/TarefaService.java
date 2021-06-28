package com.basis.colatina.service.service;

import com.basis.colatina.service.domain.Tarefa;
import com.basis.colatina.service.repository.TarefaRepository;
import com.basis.colatina.service.service.dto.TarefaDTO;
import com.basis.colatina.service.service.exception.RegraNegocioException;
import com.basis.colatina.service.service.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TarefaService {
    
    private final TarefaRepository tarefaRepository;
    
    private final TarefaMapper tarefaMapper;

    public List<TarefaDTO> listar() {
        List<Tarefa> responsaveis = tarefaRepository.findAll();
        return tarefaMapper.toDto(responsaveis);
    }

    public TarefaDTO obterPorId(Long id) {
        Tarefa usuario = get(id);
        return tarefaMapper.toDto(usuario);
    }

    private Tarefa get(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Tarefa nao encontrada"));
    }

    public TarefaDTO salvar(TarefaDTO dto) {
        Tarefa Tarefa = tarefaMapper.toEntity(dto);
        tarefaRepository.save(Tarefa);
        return tarefaMapper.toDto(Tarefa);
    }

    public void excluir(Long id) {
        Tarefa Tarefa = get(id);
        tarefaRepository.delete(Tarefa);
    }
    
}
