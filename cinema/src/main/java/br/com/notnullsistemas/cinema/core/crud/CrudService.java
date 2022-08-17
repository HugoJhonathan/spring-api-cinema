package br.com.notnullsistemas.cinema.core.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;

public abstract class CrudService<T, ID> {

    @Autowired
    protected CrudRepository<T, ID> repository;

    public Page<T> paginada(Pageable pageable){
        return repository.findAll(pageable);
    }

    public List<T> listar(){
        return repository.findAll();
    }

    public T porId(ID id){
        return repository.findById(id).orElse(null);
    }

    public T criar(T entidade){
        return repository.save(entidade);
    }

    public T editar(ID id, T entidade){
        var recuperado = porId(id);

        var entidadeSalvar = editarEntidade(recuperado, entidade);

        return repository.save(entidadeSalvar);
    }
    protected abstract T editarEntidade(T recuperado, T entidade);

    public void excluir(ID id){
        repository.deleteById(id);
    }

}
