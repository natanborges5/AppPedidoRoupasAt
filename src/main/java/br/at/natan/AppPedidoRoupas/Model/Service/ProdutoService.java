package br.at.natan.AppPedidoRoupas.Model.Service;

import br.at.natan.AppPedidoRoupas.Model.Domain.Produto;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluir(Produto produto) {
        produtoRepository.save(produto);
    }

    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Produto obterPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }
    public Collection<Produto> obterTodosPorId(List<Integer> id) {
        return (Collection<Produto>) produtoRepository.findAllById(id);
    }
    public Collection<Produto> obterLista(Usuario usuario) {
        return (Collection<Produto>) produtoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
    }

    public Collection<Produto> obterLista() {
        return (Collection<Produto>) produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
    }
}
