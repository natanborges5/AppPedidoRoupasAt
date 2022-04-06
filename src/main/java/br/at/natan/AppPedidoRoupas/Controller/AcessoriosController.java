package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Acessorios;
import br.at.natan.AppPedidoRoupas.Model.Domain.Calcados;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.AcessorioService;
import br.at.natan.AppPedidoRoupas.Model.Service.CalcadoService;
import br.at.natan.AppPedidoRoupas.Model.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
@Controller
public class AcessoriosController {
    @Autowired
    private AcessorioService acessorioService;
    @Autowired
    private ProdutoService produtoService;
    @GetMapping(value = "/acessorios")
    public String telaAcessorios(Model model){
        System.out.println(acessorioService.obterLista().size());
        model.addAttribute("calcadoLista", acessorioService.obterLista());
        System.out.println(model.getAttribute("calcadoLista"));
        return "acessorios/lista";
    }
    @GetMapping(value = "/acessorio/cadastro")
    public String telaCadastro() {
        return "/acessorios/cadastro";
    }

    @PostMapping(value = "/acessorio/cadastro")
    public String cadastrarAcessorio(Model model, Acessorios acessorios, @SessionAttribute("user") Usuario usuario){
        if (usuario.isAdmin()){
            try {
                acessorios.setUsuario(usuario);
                System.out.println(acessorios.getUsuario().getEmail());
                produtoService.incluir(acessorios);
                System.out.println(acessorios.getDescricao());
                System.out.println("acessorios cadastrada com sucesso " + acessorios.getDescricao());
            } catch (Exception e){
                System.out.println("Falha ao cadastrar acessorios " + usuario.getEmail());
                if (acessorios.getImgProduto().length() > 500) {
                    model.addAttribute("mensagem", "Dados inseridos incorretamente! O link da imagem nao pode ter mais de 500 caracteres");
                }else{
                    model.addAttribute("mensagem", "Dados inseridos incorretamente!");
                }
                return telaCadastro();
            }
        }else{
            model.addAttribute("mensagem", "Usuario nao e administrador!");
            System.out.println("Falha ao cadastrar calcados, Usuario nao e administrador!" + usuario.getNome() + usuario.isAdmin());
        }

        return "redirect:/";
    }
    @GetMapping(value = "/acessorio/{id}/excluir")
    public String excluir(@PathVariable Integer id, Model model, @SessionAttribute("user") Usuario usuario) {
        produtoService.excluir(id);
        model.addAttribute("mensagem", "Acessorio removido com sucesso");
        return telaAcessorios(model);
    }
}
