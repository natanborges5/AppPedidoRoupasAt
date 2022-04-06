package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Pedidos;
import br.at.natan.AppPedidoRoupas.Model.Domain.Produto;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.PedidoService;
import br.at.natan.AppPedidoRoupas.Model.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class CarrinhoController {
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/carrinho")
    public String telaCarrinho(Model model, @SessionAttribute("user") Usuario usuario){
        Collection<Pedidos> pedidos =  pedidoService.obterLista(usuario);
        Collection<Produto> produtos = new ArrayList<>();
        for (Pedidos pedido: pedidos){
            produtos.add(produtoService.obterPorId(pedido.getProdutos().getId()));
        }
        System.out.println(produtos.toString());
        model.addAttribute("produtoLista", produtos);
        System.out.println(model.getAttribute("produtoLista"));
        return "produtos/carrinho";
    }
    @GetMapping(value = "/carrinho/{id}/excluir")
    public String limparCarrinho(Model model, @SessionAttribute("user")Usuario usuario,@PathVariable Integer id)  {
        Pedidos pedidos = pedidoService.selectByUserAndProduto(usuario.getId(),id);
        pedidoService.excluir(pedidos.getId());
        System.out.println("Pedido excluido com sucesso"+pedidos.getId());
        model.addAttribute("mensagem", "Item removido do carrinho com Sucesso!");
        return "redirect:/";
    }
}
