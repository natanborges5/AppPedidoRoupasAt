package br.at.natan.AppPedidoRoupas.Model.Repository;

import br.at.natan.AppPedidoRoupas.Model.Domain.Produto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    @Query("from Produto p where p.usuario.id = :idUsuario")
    Collection<Produto> findAll(Integer idUsuario, Sort by);

    Collection<Produto> findAll(Sort by);

    @Query("from Produto p where p.usuario.id = :idUsuario")
    Collection<Produto> findAllById(Integer idUsuario, Sort by);

}
