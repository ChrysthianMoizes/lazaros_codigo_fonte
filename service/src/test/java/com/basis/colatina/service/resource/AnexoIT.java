package com.basis.colatina.service.resource;

import com.basis.colatina.service.builder.AnexoBuilder;
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
public class AnexoIT extends IntTestComum {

    @Autowired
    private AnexoBuilder builder;

    @Test
    public void listar() throws Exception {
        builder.construir();
        getMockMvc().perform(get("/api/anexos"))
                .andExpect(status().isOk());
    }
}
