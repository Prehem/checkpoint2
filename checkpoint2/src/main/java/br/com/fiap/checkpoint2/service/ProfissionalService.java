package br.com.fiap.checkpoint2.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.Profissional;
import br.com.fiap.checkpoint2.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public List<Profissional> listar() {
        return repository.findAll();
    }

    public Profissional buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
    }

    public Profissional salvar(Profissional profissional) {
        profissional.setCreatedAt(LocalDateTime.now());
        return repository.save(profissional);
    }

    public Profissional atualizar(Long id, Profissional novo) {
        var profissional = buscar(id);
        profissional.setNome(novo.getNome());
        profissional.setEspecialidade(novo.getEspecialidade());
        profissional.setValorHora(novo.getValorHora());
        profissional.setUpdatedAt(LocalDateTime.now());
        return repository.save(profissional);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
