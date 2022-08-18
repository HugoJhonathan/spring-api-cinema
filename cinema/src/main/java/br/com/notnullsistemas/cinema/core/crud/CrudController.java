package br.com.notnullsistemas.cinema.core.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

public abstract class CrudController<T extends CrudDomain<ID>, ID> {

    @Autowired
    protected CrudService<T, ID> service;

    @GetMapping
    public ResponseEntity<List<T>> todos() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> listarUm(@PathVariable("id") ID id) {
        var entidade = service.porId(id);
        return ResponseEntity.ok(entidade);
    }

    @PostMapping
    public ResponseEntity<T> criar(@RequestBody T entidade) {
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        var uri = builder.path("/{id}").buildAndExpand(entidade.getId()).toUri(); // id da entity criada
        return ResponseEntity.created(uri).body(service.criar(entidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> editar(@RequestBody T entidade, @PathVariable("id") ID id) {
        var salvo = service.editar(id, entidade);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") ID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
