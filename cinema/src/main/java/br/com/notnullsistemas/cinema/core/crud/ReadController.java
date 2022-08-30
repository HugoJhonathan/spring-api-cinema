package br.com.notnullsistemas.cinema.core.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class ReadController<T extends CrudDomain<ID>, D, ID> {

    @Autowired
    protected CrudService<T, ID> service;

    @Autowired
    protected  CrudConverter<T, D> converter;

//    @GetMapping
//    public ResponseEntity<Page<D>> paginada(Pageable pageable){
//        var listaPaginada= service.paginada(pageable).map(converter::entidadeParaDto);
//        return ResponseEntity.ok(listaPaginada);
//    }

    @GetMapping
    public ResponseEntity<List<D>> listarTodos(){

        var ListaDto= service.listar()
                .stream()
                .map(converter::entidadeParaDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ListaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> listarUm(@PathVariable("id") ID id) throws Exception {

        var entidade = service.porId(id);

        if(Objects.isNull(entidade)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(converter.entidadeParaDto(entidade));
    }

}
