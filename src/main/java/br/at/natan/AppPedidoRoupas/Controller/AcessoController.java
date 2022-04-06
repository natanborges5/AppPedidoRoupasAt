package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.ProdutoService;
import br.at.natan.AppPedidoRoupas.Model.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class AcessoController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProdutoService produtoService;
    @GetMapping(value = "/")
    public String telaHome(Model model) {
        model.addAttribute("produtoLista", produtoService.obterLista());
        return "index";
    }

    @GetMapping(value = "/login")
    public String telaLogin(){
        return "usuario/login";
    }

    @GetMapping(value = "/logout")
    public String logout(SessionStatus status, HttpSession session,Model model) {

        status.setComplete();
        session.removeAttribute("user");model.addAttribute(
                "mensagem",
                "Logout realizado com sucesso!!"
        );
        return "redirect:/";
    }
    @PostMapping(value = "/login")
    public String usuarioLogin(Model model, @RequestParam String email, @RequestParam String senha){

        Usuario usuario = usuarioService.loginUser(email,senha);
        if(usuario != null) {
            model.addAttribute("user", usuario);
            model.addAttribute(
                    "mensagem",
                    "Login realizado com sucesso!!"
            );
            return telaHome(model);
        } else {
            model.addAttribute(
                    "mensagem",
                    "As credenciais do usuário "+ email +" estão incorretas!!!"
            );
            return telaLogin();
        }

    }
}
