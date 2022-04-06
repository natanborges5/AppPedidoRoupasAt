package br.at.natan.AppPedidoRoupas.Model.Service;

import br.at.natan.AppPedidoRoupas.Model.Domain.Pedidos;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Collection<Pedidos> obterLista(Usuario usuario){
        return (Collection<Pedidos>) pedidoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "data"));
    }

    public Collection<Pedidos> obterLista(){
        return (Collection<Pedidos>) pedidoRepository.findAll();
    }

    public Pedidos incluir(Pedidos pedidos){
        return pedidoRepository.save(pedidos);
    }

    public void excluir(Integer id) {
        pedidoRepository.deleteById(id);
    }
    public Pedidos selectByUserAndProduto(Integer id,Integer idProduto) {
       return pedidoRepository.selectByIdProdutoAndIdUser(id,idProduto);
    }

    public Pedidos obterPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedidos obterPorProdutoId(Integer id) {
        return pedidoRepository.findByProdutoId(id);
    }
}
