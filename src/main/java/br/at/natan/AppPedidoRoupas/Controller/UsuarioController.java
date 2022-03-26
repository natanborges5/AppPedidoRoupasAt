package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "/usuario/cadastro";
    }


    @GetMapping(value = "/usuarios")
    public String telaLista(Model model){
        model.addAttribute("usuarioLista",usuarioService.obterLista());
        return  "usuario/lista";
    }

    @PostMapping(value = "/usuario/cadastro")
    public String cadastrarUsuario(Model model,Usuario usuario){
        usuarioService.incluir(usuario);
        model.addAttribute("nomeUsuario",usuario.getNome());
        model.addAttribute("emailUsuario",usuario.getEmail());
        System.out.println("Usuario cadastrado com sucesso" + usuario.getEmail());
        return "usuario/confirmacaoCadastro";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
    public String excluirUsuario(Model model,@PathVariable Integer id){
        Usuario usuario = usuarioService.obterPorId(id);
        if(usuario.getId() != null) {
            usuarioService.excluir(id);
            model.addAttribute("mensagem", "O usuário "+usuario.getNome()+" foi excluído com sucesso!!!");
        } else {
            model.addAttribute("mensagem", "Usuário inexistente.. impossível realizar a exclusão!!!");
        }
        return telaLista(model);
    }
}
