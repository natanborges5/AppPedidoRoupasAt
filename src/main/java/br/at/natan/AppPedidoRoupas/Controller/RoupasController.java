package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.ProdutoService;
import br.at.natan.AppPedidoRoupas.Model.Service.RoupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class RoupasController {
    @Autowired
    private RoupaService roupaService;
    @Autowired
    private ProdutoService produtoService;
    @GetMapping(value = "/roupas")
    public String telaRoupas(Model model){
        System.out.println(roupaService.obterLista().size());
        model.addAttribute("roupaLista", roupaService.obterLista());
        System.out.println(model.getAttribute("roupaLista"));
        return "roupas/lista";
    }
    @GetMapping(value = "/roupas/cadastro")
    public String telaCadastro() {
        return "/roupas/cadastro";
    }

    @PostMapping(value = "/roupas/cadastro")
    public String cadastrarUsuario(Model model, Roupas roupa, @SessionAttribute("user") Usuario usuario){
        System.out.println(usuario.getEmail());
        System.out.println(usuario.isAdmin());
        if (usuario.isAdmin()){
            try {
                roupa.setUsuario(usuario);
                System.out.println(roupa.getUsuario().getEmail());
                produtoService.incluir(roupa);
                System.out.println(roupa.getDescricao());
                System.out.println("Roupa cadastrada com sucesso" + roupa.getDescricao());
            } catch (Exception e){
                System.out.println("Falha ao cadastrar roupa " + usuario.getEmail());
                if (roupa.getImgProduto().length() > 500) {
                    model.addAttribute("mensagem", "Dados inseridos incorretamente! O link da imagem nao pode ter mais de 500 caracteres");
                }else{
                    model.addAttribute("mensagem", "Dados inseridos incorretamente!");
                }
                return telaCadastro();
            }
        }else{
            model.addAttribute("mensagem", "Usuario nao e administrador!");
            System.out.println("Falha ao cadastrar roupa Usuario nao e administrador!" + usuario.getNome() + usuario.isAdmin());
        }

        return "redirect:/";
    }
    @GetMapping(value = "/roupa/{id}/excluir")
    public String excluir(@PathVariable Integer id,Model model,@SessionAttribute("user") Usuario usuario) {
        produtoService.excluir(id);
        model.addAttribute("mensagem", "Roupa removida com sucesso");
        return telaRoupas(model);
    }
}
