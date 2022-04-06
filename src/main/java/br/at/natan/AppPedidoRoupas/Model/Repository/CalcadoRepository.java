package br.at.natan.AppPedidoRoupas.Model.Repository;

import br.at.natan.AppPedidoRoupas.Model.Domain.Calcados;
import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CalcadoRepository extends CrudRepository<Calcados, Integer> {
    @Query("from Calcados p where p.usuario.id = :idUsuario")
    Collection<Calcados> findAll(Integer idUsuario, Sort by);
    Collection<Calcados> findAll(Sort by);
}
