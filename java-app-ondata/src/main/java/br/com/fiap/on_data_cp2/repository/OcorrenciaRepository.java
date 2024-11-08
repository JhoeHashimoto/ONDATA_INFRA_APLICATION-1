package br.com.fiap.on_data_cp2.repository;

import br.com.fiap.on_data_cp2.entity.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    List<Ocorrencia> findByAprovadoTrue();

    List<Ocorrencia> findByAprovadoFalse();
}
