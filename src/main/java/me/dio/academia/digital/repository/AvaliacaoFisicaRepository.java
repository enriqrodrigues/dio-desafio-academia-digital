package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM tb_avaliacoes WHERE aluno_id = ?1 ;")
    List<AvaliacaoFisica> findByIdAluno(Long idAluno);
}
