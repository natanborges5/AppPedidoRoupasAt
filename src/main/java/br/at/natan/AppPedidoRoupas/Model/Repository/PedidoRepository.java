package br.at.natan.AppPedidoRoupas.Model.Repository;

import br.at.natan.AppPedidoRoupas.Model.Domain.Pedidos;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PedidoRepository extends CrudRepository<Pedidos, Integer> {
    @Query("from Pedidos p where p.usuario.id = :idUsuario")
    Collection<Pedidos> findAll(Integer idUsuario, Sort by);

    @Query("select p  from Pedidos p where p.usuario.id = :idUsuario and p.produtos.id = :idProduto")
    Pedidos selectByIdProdutoAndIdUser(Integer idUsuario, Integer idProduto);
    @Query("from Pedidos p where p.produtos.id = :id")
    Pedidos findByProdutoId(Integer id);
}