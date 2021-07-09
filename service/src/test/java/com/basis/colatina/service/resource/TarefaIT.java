package com.basis.colatina.service.resource;

import com.basis.colatina.service.builder.TarefaBuilder;
import com.basis.colatina.service.config.containers.ContainersFactory;
import com.basis.colatina.service.repository.elasticsearch.TarefaSearchRepository;
import com.basis.colatina.service.util.IntTestComum;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Transactional
public class TarefaIT extends IntTestComum {

    @Autowired
    private TarefaBuilder builder;

    @Autowired
    private TarefaSearchRepository tarefaSearchRepository;

    public static ContainersFactory containers = ContainersFactory.getInstances();

    @Test
    public void listar() throws Exception {
        builder.construir();
        getMockMvc().perform(get("/api/tarefas"))
                .andExpect(status().isOk());
    }
}
