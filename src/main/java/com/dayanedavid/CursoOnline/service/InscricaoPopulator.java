package com.dayanedavid.CursoOnline.service;

import com.dayanedavid.CursoOnline.model.dto.AlunoDTO;
import com.dayanedavid.CursoOnline.model.dto.CursoDTO;
import com.dayanedavid.CursoOnline.model.entity.Aluno;
import com.dayanedavid.CursoOnline.model.entity.Curso;
import org.springframework.stereotype.Service;

@Service
public class InscricaoPopulator {
    public AlunoDTO converterAluno(Aluno aluno) {

        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setEmail(aluno.getEmail());
        alunoDTO.setDataCadastro(aluno.getDataCadastro());
        return alunoDTO;
    }

    public CursoDTO converterCurso(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNome(curso.getNome());
        cursoDTO.setDescricao(curso.getDescricao());
        cursoDTO.setDataCriacao(curso.getDataCriacao());
        return cursoDTO;
    }
}
