package br.com.notnullsistemas.cinema.core.crud;

import br.com.notnullsistemas.cinema.core.exception.CinemaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class CrudService<T, ID> {

    @Autowired
    protected CrudRepository<T, ID> repository;

    public Page<T> paginada(Pageable pageable){
        return repository.findAll(pageable);
    }

    public List<T> listar(){
        return repository.findAll();
    }

    public T porId(ID id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() ->
                        new CinemaException("ID: "+id+" não existe")
                );
    }

    public T criar(T entidade) throws Exception {
        validar(entidade);
        return repository.save(entidade);
    }

    protected abstract void validar(T entidade) throws Exception;

    public T editar(ID id, T entidade) throws Exception {
        var recuperado = porId(id);
        validar(entidade);
        editarEntidade(entidade, recuperado);
        return repository.save(recuperado);
    }
    protected abstract void editarEntidade(T entidade, T recuperado);

    public void excluir(ID id){
        repository.deleteById(id);
    }

}
