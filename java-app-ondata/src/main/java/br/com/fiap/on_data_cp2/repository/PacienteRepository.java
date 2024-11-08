package br.com.fiap.on_data_cp2.repository;

import br.com.fiap.on_data_cp2.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
