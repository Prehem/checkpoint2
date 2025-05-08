package br.com.fiap.checkpoint2.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public List<Paciente> listar() {
        return repository.findAll();
    }

    public Paciente buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public Paciente salvar(Paciente paciente) {
        paciente.setCreatedAt(LocalDateTime.now());
        return repository.save(paciente);
    }

    public Paciente atualizar(Long id, Paciente novo) {
        var paciente = buscar(id);
        paciente.setNome(novo.getNome());
        paciente.setEndereco(novo.getEndereco());
        paciente.setUpdatedAt(LocalDateTime.now());
        return repository.save(paciente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
