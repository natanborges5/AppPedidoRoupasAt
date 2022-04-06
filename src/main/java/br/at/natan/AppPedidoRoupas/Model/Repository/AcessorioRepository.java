package br.at.natan.AppPedidoRoupas.Model.Repository;

import br.at.natan.AppPedidoRoupas.Model.Domain.Acessorios;
import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AcessorioRepository extends CrudRepository<Acessorios, Integer> {
    @Query("from Acessorios s where s.usuario.id = :idUsuario")
    Collection<Acessorios> findAll(Integer idUsuario, Sort by);
    Collection<Acessorios> findAll(Sort by);
}
