package br.at.natan.AppPedidoRoupas.Model.Repository;

import br.at.natan.AppPedidoRoupas.Model.Domain.Produto;
import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoupaRepository extends CrudRepository<Roupas, Integer> {
    @Query("from Roupas p where p.usuario.id = :idUsuario")
    Collection<Roupas> findAll(Integer idUsuario, Sort by);
    Collection<Roupas> findAll(Sort by);
}
