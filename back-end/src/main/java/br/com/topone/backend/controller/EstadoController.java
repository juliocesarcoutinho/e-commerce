package br.com.topone.backend.controller;

import br.com.topone.backend.exception.EntidadeEmUsoException;
import br.com.topone.backend.exception.EntidadeNaoEncontradaException;
import br.com.topone.backend.model.Estado;
import br.com.topone.backend.service.EstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> listar() {
        List<Estado> estados = estadoService.listar();
        return ResponseEntity.ok().body(estados);
    }

    @PostMapping
    public ResponseEntity<Estado> adicionar(@RequestBody Estado estado) {
        Estado estadoSalvo = estadoService.adicionar(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterar(@PathVariable Long id,
                                          @RequestBody Estado estado) {
        try {
            estadoService.atualizar(id, estado);
            return ResponseEntity.ok("Estado alterado com sucesso");
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.noContent().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        Estado estado = estadoService.buscar(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Estado com id %d não encontrado", id)));

        try {
            estadoService.remover(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Estado com id %d não pode ser removido, pois está em uso", id));
        }
    }

}
