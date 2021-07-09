package com.basis.colatina.service.builder;

import com.basis.colatina.service.domain.Anexo;
import com.basis.colatina.service.domain.Responsavel;
import com.basis.colatina.service.service.AnexoService;
import com.basis.colatina.service.service.ResponsavelService;
import com.basis.colatina.service.service.dto.AnexoDTO;
import com.basis.colatina.service.service.dto.ResponsavelDTO;
import com.basis.colatina.service.service.mapper.AnexoMapper;
import com.basis.colatina.service.service.mapper.ResponsavelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class AnexoBuilder extends ConstrutorDeEntidade<Anexo> {

    @Autowired
    private AnexoService service;

    @Autowired
    private AnexoMapper mapper;

    @Autowired
    private TarefaBuilder tarefaBuilder;

    @Override
    public Anexo construirEntidade() throws ParseException {

        Anexo anexo = new Anexo();
        anexo.setTamanho("25KB");
        anexo.setTarefa(tarefaBuilder.construir());
        anexo.setTipo("DOCUMENTO");
        anexo.setTitulo("Titulo do anexo");

        return anexo;
    }

    @Override
    protected Anexo persistir(Anexo entidade) {
        AnexoDTO dto = service.salvar(mapper.toDto(entidade));
        return mapper.toEntity(dto);
    }

    @Override
    protected Collection<Anexo> obterTodos() {
        return null;
    }

    @Override
    protected Anexo obterPorId(Integer id) {
        return null;
    }
}
