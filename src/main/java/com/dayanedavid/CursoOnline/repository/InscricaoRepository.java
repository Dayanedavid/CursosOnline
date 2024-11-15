package com.dayanedavid.CursoOnline.repository;

import com.dayanedavid.CursoOnline.model.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    List<Inscricao> findByAlunoId(Long aluno);
    List<Inscricao> findByCursoId(Long curso);


}
