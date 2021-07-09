package com.basis.colatina.service.builder;

import com.basis.colatina.service.domain.Responsavel;
import com.basis.colatina.service.service.ResponsavelService;
import com.basis.colatina.service.service.dto.ResponsavelDTO;
import com.basis.colatina.service.service.mapper.ResponsavelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class ResponsavelBuilder extends ConstrutorDeEntidade<Responsavel> {

    @Autowired
    private ResponsavelService responsavelService;

    @Autowired
    private ResponsavelMapper responsavelMapper;

    @Override
    public Responsavel construirEntidade() throws ParseException {

        Responsavel responsavel = new Responsavel();

        responsavel.setEmail("responsavel@gmail.com");
        responsavel.setDataNascimento(LocalDate.now());
        responsavel.setSituacao(true);
        responsavel.setNome("Responsavel 1");

        return responsavel;
    }

    @Override
    protected Responsavel persistir(Responsavel entidade) {
        ResponsavelDTO dto = responsavelService.salvar(responsavelMapper.toDto(entidade));
        return responsavelMapper.toEntity(dto);
    }

    @Override
    protected Collection<Responsavel> obterTodos() {
        return null;
    }

    @Override
    protected Responsavel obterPorId(Integer id) {
        return null;
    }
}
