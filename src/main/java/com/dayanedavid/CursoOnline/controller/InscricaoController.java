package com.dayanedavid.CursoOnline.controller;

import com.dayanedavid.CursoOnline.model.dto.InscricaoRequest;
import com.dayanedavid.CursoOnline.model.entity.Aluno;
import com.dayanedavid.CursoOnline.model.entity.Curso;
import com.dayanedavid.CursoOnline.model.entity.Inscricao;
import com.dayanedavid.CursoOnline.repository.AlunoRepository;
import com.dayanedavid.CursoOnline.repository.CursoRepository;
import com.dayanedavid.CursoOnline.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository;


    @PostMapping
        public ResponseEntity inscrever(@RequestBody InscricaoRequest inscricaoRequest) {

        Optional<Aluno> aluno = alunoRepository.findById(inscricaoRequest.getAlunoId());
        Optional<Curso> curso = cursoRepository.findById(inscricaoRequest.getCursoId());

        if(aluno.isEmpty() || curso.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno.get());
        inscricao.setCurso(curso.get());

        inscricaoRepository.save(inscricao);

        return ResponseEntity.ok().build();

    }

}
