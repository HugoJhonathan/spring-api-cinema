package br.com.notnullsistemas.cinema.core.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

public abstract class CrudController<T extends CrudDomain<ID>, D, ID> extends ReadController<T, D, ID> {

    @PostMapping
    public ResponseEntity<D> criar(@RequestBody @Valid D dto) throws Exception {

        var entidade = converter.dtoParaEntidade(dto);
        var salvo = service.criar(entidade);
        var salvoDto = converter.entidadeParaDto(salvo);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        var uri = builder.path("/{id}").buildAndExpand(salvo.getId()).toUri();
        return ResponseEntity.created(uri).body(salvoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> editar(@RequestBody D dto, @PathVariable("id") ID id) throws Exception {


        var novaEntidade = converter.dtoParaEntidade(dto);
        novaEntidade.setId(id);

        var salvo = service.editar(id, novaEntidade);
        var salvoDto = converter.entidadeParaDto(salvo);
        return ResponseEntity.ok(salvoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") ID id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
