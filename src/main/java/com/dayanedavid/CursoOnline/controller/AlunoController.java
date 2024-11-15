package com.dayanedavid.CursoOnline.controller;

import com.dayanedavid.CursoOnline.model.dto.AlunoDTO;
import com.dayanedavid.CursoOnline.model.dto.CursoDTO;
import com.dayanedavid.CursoOnline.model.entity.Aluno;
import com.dayanedavid.CursoOnline.model.entity.Curso;
import com.dayanedavid.CursoOnline.repository.AlunoRepository;
import com.dayanedavid.CursoOnline.service.AlunoService;
import com.dayanedavid.CursoOnline.service.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO cadastrarCurso(@RequestBody Aluno aluno) {

        aluno = alunoRepository.save(aluno);
        return inscricaoPopulator.converterAluno(aluno);

    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getCursosByAluno(@RequestParam(name = "id") Long id){

        Optional<Aluno> aluno = this.alunoRepository.findById(id);

        if(!aluno.isEmpty()) {
            List<Curso> cursos = alunoService.getCursos(aluno.get().getId());

            List<CursoDTO> cursosDTO = cursos.stream().map(i -> inscricaoPopulator.converterCurso(i))
                    .collect(Collectors.toList());


            return ResponseEntity.ok(cursosDTO);
        }

        return ResponseEntity.notFound().build();
    }


}
