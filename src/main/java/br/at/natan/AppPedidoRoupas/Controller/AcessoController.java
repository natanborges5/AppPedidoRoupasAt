package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Cliente;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;
import br.at.natan.AppPedidoRoupas.Model.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.AbstractList;
import java.util.Objects;
@SessionAttributes("user")
@Controller
public class AcessoController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping(value = "/")
    public String telaHome() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String telaLogin(){
        return "usuario/login";
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
            return "usuario/home";
        } else {
            model.addAttribute(
                    "mensagem",
                    "As credenciais do usuário "+ email +" estão incorretas!!!"
            );
            return telaLogin();
        }

    }
}
