package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.model.Profissional;
import br.com.fiap.checkpoint2.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @GetMapping
    public List<Profissional> listar() {
        return service.listar();
    }

    @GetMapping("{id}")
    public ResponseEntity<Profissional> buscar(@PathVariable Long id) {
        var profissional = service.buscar(id);
        return ResponseEntity.ok(profissional);
    }

    @PostMapping
    public ResponseEntity<Profissional> cadastrar(@RequestBody Profissional profissional) {
        var novo = service.salvar(profissional);
        return ResponseEntity.status(201).body(novo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long id, @RequestBody Profissional profissional) {
        var atualizado = service.atualizar(id, profissional);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
