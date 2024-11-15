package com.dayanedavid.CursoOnline.controller;


import com.dayanedavid.CursoOnline.model.dto.AlunoDTO;
import com.dayanedavid.CursoOnline.model.dto.CursoDTO;
import com.dayanedavid.CursoOnline.model.entity.Aluno;
import com.dayanedavid.CursoOnline.model.entity.Curso;
import com.dayanedavid.CursoOnline.repository.CursoRepository;
import com.dayanedavid.CursoOnline.service.CursoService;
import com.dayanedavid.CursoOnline.service.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDTO cadastrarCurso(@RequestBody Curso curso) {
        curso = cursoRepository.save(curso);
        return inscricaoPopulator.converterCurso(curso);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> getAlunosByCurso(@RequestParam(name = "id") Long id){

        Optional<Curso> curso = cursoRepository.findById(id);

        if(!curso.isEmpty()) {
            List<Aluno> alunos = cursoService.getAlunos(curso.get().getId());

            List<AlunoDTO> alunosDTO = alunos.stream().map(i -> inscricaoPopulator.converterAluno(i))
                    .collect(Collectors.toList());


            return ResponseEntity.ok(alunosDTO);
        }

        return ResponseEntity.notFound().build();
    }

}
