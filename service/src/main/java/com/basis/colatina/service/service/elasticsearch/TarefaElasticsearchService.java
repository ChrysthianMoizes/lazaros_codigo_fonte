package com.basis.colatina.service.service.elasticsearch;

import com.basis.colatina.service.domain.elasticsearch.TarefaDocument;
import com.basis.colatina.service.repository.TarefaRepository;
import com.basis.colatina.service.repository.elasticsearch.TarefaSearchRepository;
import com.basis.colatina.service.service.dto.TarefaDTO;
import com.basis.colatina.service.service.event.TarefaEvent;
import com.basis.colatina.service.service.filter.TarefaFilter;
import com.basis.colatina.service.service.mapper.TarefaListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
@Slf4j
public class TarefaElasticsearchService {

    private final TarefaSearchRepository tarefaSearchRepository;

    private final TarefaRepository tarefaRepository;

    private final TarefaListMapper tarefaListMapper;

    @TransactionalEventListener(fallbackExecution = true)
    public void reindex(TarefaEvent event) {
        log.info("Reindexando entidade Tarefa {}", event.getId());
        TarefaDocument document = tarefaRepository.getDocument(event.getId());
        tarefaSearchRepository.save(document);
    }

    public Page<TarefaDTO> search(TarefaFilter filter, Pageable pageable) {
        return tarefaSearchRepository.search(filter.getFilter(), pageable).map(tarefaListMapper::toDto);
    }

}
