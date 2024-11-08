package br.com.fiap.on_data_cp2.repository;

import br.com.fiap.on_data_cp2.entity.Doenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoencaRepository extends JpaRepository<Doenca, Long> {
}
