package br.com.fiap.on_data_cp2.service;

import br.com.fiap.on_data_cp2.controller.dto.PacienteDTO;
import br.com.fiap.on_data_cp2.entity.Categoria;
import br.com.fiap.on_data_cp2.entity.Genero;
import br.com.fiap.on_data_cp2.entity.Ocorrencia;
import br.com.fiap.on_data_cp2.entity.Paciente;
import br.com.fiap.on_data_cp2.exception.NaoEncontradoException;
import br.com.fiap.on_data_cp2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO) {
        Paciente savedPaciente = pacienteRepository.save(convertToEntity(pacienteDTO));
        pacienteDTO.setId(savedPaciente.getId());
        return pacienteDTO;
    }

    public Page<PacienteDTO> listarPacientes(Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(this::convertToDTO);
    }

    public PacienteDTO buscarPacientePorId(Long id) {
        Paciente foundPaciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Clínica não encontrada"));
        return convertToDTO(foundPaciente);
    }

    public void deletarPaciente(Long id) {pacienteRepository.deleteById(id);}

    private PacienteDTO convertToDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNome(paciente.getNome());
        pacienteDTO.setGenero(paciente.getGenero());
        pacienteDTO.setEndereco(paciente.getEndereco());
        pacienteDTO.setCidade(paciente.getCidade());
        pacienteDTO.setFumante(paciente.isFumante());
        pacienteDTO.setRenda(paciente.getRenda());
        pacienteDTO.setVisitasPorAno(paciente.getVisitasPorAno());
        pacienteDTO.setCategoria(paciente.getCategoria());

        return pacienteDTO;
    }

    private Paciente convertToEntity(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setGenero(pacienteDTO.getGenero());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setCidade(pacienteDTO.getCidade());
        paciente.setFumante(pacienteDTO.isFumante());
        paciente.setRenda(pacienteDTO.getRenda());
        paciente.setVisitasPorAno(pacienteDTO.getVisitasPorAno());
        paciente.setCategoria(pacienteDTO.getCategoria());

        return paciente;
    }
}
