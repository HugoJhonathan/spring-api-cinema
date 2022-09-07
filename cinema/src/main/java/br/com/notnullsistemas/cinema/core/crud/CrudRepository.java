package br.com.notnullsistemas.cinema.core.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CrudRepository<T, ID> extends JpaRepository<T, ID>{


}
