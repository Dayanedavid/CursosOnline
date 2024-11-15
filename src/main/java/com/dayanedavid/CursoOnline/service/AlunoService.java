package com.dayanedavid.CursoOnline.service;

import com.dayanedavid.CursoOnline.model.entity.Curso;
import com.dayanedavid.CursoOnline.model.entity.Inscricao;
import com.dayanedavid.CursoOnline.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public List<Curso> getCursos(Long alunoId) {

        List<Inscricao> inscricoes = inscricaoRepository.findByAlunoId(alunoId);

        return inscricoes.stream()
                .map(i -> i.getCurso() )
                .collect(Collectors.toList());
    }
}
