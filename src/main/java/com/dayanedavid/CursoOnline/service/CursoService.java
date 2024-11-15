package com.dayanedavid.CursoOnline.service;

import com.dayanedavid.CursoOnline.model.entity.Aluno;
import com.dayanedavid.CursoOnline.model.entity.Inscricao;
import com.dayanedavid.CursoOnline.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public List<Aluno> getAlunos(Long cursoId) {

        List<Inscricao> inscricoes = inscricaoRepository.findByCursoId(cursoId);

        return inscricoes.stream()
                .map(i -> i.getAluno() )
                .collect(Collectors.toList());
    }
}
