package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Calcados;
import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.CalcadoService;
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
public class CalcadosController {
    @Autowired
    private CalcadoService calcadoService;
    @Autowired
    private ProdutoService produtoService;
    @GetMapping(value = "/calcados")
    public String telaCalcados(Model model){
        System.out.println(calcadoService.obterLista().size());
        model.addAttribute("calcadoLista", calcadoService.obterLista());
        System.out.println(model.getAttribute("calcadoLista"));
        return "calcados/lista";
    }
    @GetMapping(value = "/calcado/cadastro")
    public String telaCadastro() {
        return "/calcados/cadastro";
    }

    @PostMapping(value = "/calcado/cadastro")
    public String cadastrarCalcado(Model model, Calcados calcados, @SessionAttribute("user") Usuario usuario){
        System.out.println(usuario.getEmail());
        System.out.println(usuario.isAdmin());
        if (usuario.isAdmin()){
            try {
                calcados.setUsuario(usuario);
                System.out.println(calcados.getUsuario().getEmail());
                produtoService.incluir(calcados);
                System.out.println(calcados.getDescricao());
                System.out.println("calcados cadastrada com sucesso" + calcados.getDescricao());
            } catch (Exception e){
                System.out.println("Falha ao cadastrar calcados " + usuario.getEmail());
                if (calcados.getImgProduto().length() > 500) {
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
    @GetMapping(value = "/calcado/{id}/excluir")
    public String excluir(@PathVariable Integer id, Model model, @SessionAttribute("user") Usuario usuario) {
        produtoService.excluir(id);
        model.addAttribute("mensagem", "calcado removida com sucesso");
        return telaCalcados(model);
    }
}
