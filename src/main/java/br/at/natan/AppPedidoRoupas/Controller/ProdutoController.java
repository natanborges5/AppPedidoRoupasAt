package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Pedidos;
import br.at.natan.AppPedidoRoupas.Model.Domain.Produto;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.PedidoService;
import br.at.natan.AppPedidoRoupas.Model.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private PedidoService pedidoService;


    @GetMapping(value = "/produto/{id}")
    public String telaProduto(Model model, @PathVariable Integer id){
        System.out.println(produtoService.obterPorId(id).getDescricao());
        model.addAttribute("produtoLista", produtoService.obterPorId(id));
        return "produtos/lista";
    }

    @PostMapping(value = "/produto/{id}/adicionar")
    public String adicionarCarrinho(Model model,@PathVariable Integer id ,@SessionAttribute("user") Usuario usuario){
        if (pedidoService.obterPorProdutoId(id) == null){
            try {
                Pedidos pedidos = new Pedidos();
                pedidos.setProdutos(produtoService.obterPorId(id));
                pedidos.setUsuario(usuario);
                //pedidos.setIdDoUsuario(usuario.getId());
                pedidoService.incluir(pedidos);
                model.addAttribute("mensagem", "Item adicionado ao carrinho!!");
                return telaProduto(model,id);
            } catch (Exception e){
                System.out.println("Falha ao adicionar item ao carrinho " + produtoService.obterPorId(id));
                model.addAttribute("mensagem", "Erro ao adicionar item ao carrinho");
                return telaProduto(model,id);
            }
        }else {
            System.out.println("Item ja esta no carrinho " + produtoService.obterPorId(id));
            model.addAttribute("mensagem", "Item ja esta adicionado ao carrinho!");
            return telaProduto(model,id);
        }
    }
    @GetMapping(value = "/produto/{id}/excluir")
    public String excluirProduto(Model model,@PathVariable Integer id,@SessionAttribute("user") Usuario usuario){
        Produto produto = produtoService.obterPorId(id);
        if(usuario.isAdmin()){
            try{
                if(usuario.getId() != null) {
                    produtoService.excluir(id);
                    model.addAttribute("mensagem", "O Produto "+ produto.getDescricao() + " foi excluído com sucesso!!!");
                } else {
                    model.addAttribute("mensagem", "Produto inexistente.. impossível realizar a exclusão!!!");
                }
                return "redirect:/";
            }catch (Exception e){
                model.addAttribute("mensagem", "Erro ao excluir produto " + produto.getDescricao());
                return "redirect:/";
            }
        }else{
            model.addAttribute("mensagem", "Voce nao tem permissao administrador ");
            return "redirect:/";
        }
    }
}
