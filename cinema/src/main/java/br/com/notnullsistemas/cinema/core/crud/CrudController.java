package br.com.notnullsistemas.cinema.core.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public abstract class CrudController<T extends CrudDomain<ID>, D, ID> extends ReadController<T, D, ID> {

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
