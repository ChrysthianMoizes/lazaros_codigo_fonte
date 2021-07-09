package com.basis.colatina.service.builder;

import com.basis.colatina.service.domain.Tarefa;
import com.basis.colatina.service.service.TarefaService;
import com.basis.colatina.service.service.dto.TarefaDTO;
import com.basis.colatina.service.service.mapper.TarefaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Collection;

@Component
public class TarefaBuilder extends ConstrutorDeEntidade<Tarefa> {

    @Autowired
    private TarefaService service;

    @Autowired
    private TarefaMapper mapper;

    @Autowired
    private ResponsavelBuilder responsavelBuilder;

    @Override
    public Tarefa construirEntidade() throws ParseException {

        Tarefa tarefa = new Tarefa();

        tarefa.setResponsavel(responsavelBuilder.construir());
        tarefa.setComentarios("Comentarios");
        tarefa.setDataInicio(LocalDateTime.now());
        tarefa.setDataTermino(LocalDateTime.now());
        tarefa.setDataInicioPrevista(LocalDateTime.now());
        tarefa.setDataTerminoPrevista(LocalDateTime.now());
        tarefa.setStatus("PENDENTE");
        tarefa.setDescricao("Descriçao da tarefa");
        tarefa.setTitulo("Titulo da tarefa");
        tarefa.setTipo("CODIFICACAO");

        return tarefa;
    }

    @Override
    protected Tarefa persistir(Tarefa entidade) {
        TarefaDTO dto = service.salvar(mapper.toDto(entidade));
        return mapper.toEntity(dto);
    }

    @Override
    protected Collection<Tarefa> obterTodos() {
        return null;
    }

    @Override
    protected Tarefa obterPorId(Integer id) {
        return null;
    }
}
