package com.basis.colatina.service.service.elasticsearch;

import com.basis.colatina.service.repository.elasticsearch.Reindexador;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElasticsearchService {

    @Value("${application.elasticsearch.pageSize:1000}")
    private Integer pageSize;

    private final List<Reindexador> reindexadores;

    private final List<ElasticsearchRepository> repositories;

    private final ElasticsearchRestTemplate elasticsearchTemplate;

    public void reindex() {
        log.info("Iniciando reindexação");
        for (Reindexador reindexador : reindexadores) {
            reindex(reindexador);
        }
    }

    public void reindexEntity(String entity) {
        log.info("Iniciando reindexação {}", entity);
        for (Reindexador reindexador : reindexadores) {
            if(reindexador.getEntity().equals(entity)) {
                reindex(reindexador);
            }
        }
    }

    private void reindex(Reindexador reindexador) {
        Pageable pageable = PageRequest.of(0, pageSize);

        Page<?> page = reindexador.reindexPage(pageable);

        if(page.isEmpty()) {
            return;
        }

        ElasticsearchRepository repository = getRepository(page);
        recreateIndex(repository.getEntityClass());

        while (page.hasContent()) {
            repository.saveAll(page);
            page = reindexador.reindexPage(page.getPageable().next());
        }

    }

    private <T> void recreateIndex(Class<T> entityClass) {
        elasticsearchTemplate.deleteIndex(entityClass);
        elasticsearchTemplate.createIndex(entityClass);
        elasticsearchTemplate.putMapping(entityClass);
    }

    private ElasticsearchRepository getRepository(Page<?> page) {

        Class documentClass = page.getContent().get(0).getClass();

        Iterator<ElasticsearchRepository> repositoryIterator = repositories.iterator();

        ElasticsearchRepository elasticsearchRepository;

        do {

            if(!repositoryIterator.hasNext()) {
                throw new RuntimeException("Falha na reindexação...");
            }

            elasticsearchRepository = repositoryIterator.next();
        } while (!elasticsearchRepository.getEntityClass().equals(documentClass));

        return elasticsearchRepository;
    }

}
