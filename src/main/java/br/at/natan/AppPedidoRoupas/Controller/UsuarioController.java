package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro() {
        return "/usuario/cadastro";
    }


    @GetMapping(value = "/usuarios")
    public String telaLista(Model model){
        model.addAttribute("usuarioLista",usuarioService.obterLista());
        return  "usuario/lista";
    }
    @GetMapping(value = "/usuario/perfil")
    public String telaPerfil(){
        return  "usuario/perfil";
    }

    @PostMapping(value = "/usuario/cadastro")
    public String cadastrarUsuario(Model model,Usuario usuario){
        Usuario usuarioCadastrado = usuarioService.obterPorEmail(usuario.getEmail());
        if (usuarioCadastrado == null){
            if (usuario.isAdmin() && Objects.equals(usuario.getSenhaAdmin(), "admin123")) {
                try {
                    usuarioService.incluir(usuario);
                    System.out.println(usuario.getSenhaAdmin());
                    model.addAttribute("nomeUsuario", usuario.getNome());
                    model.addAttribute("emailUsuario", usuario.getEmail());
                    System.out.println("Usuario admin cadastrado com sucesso" + usuario.getEmail());
                    return "redirect:/login";
                } catch (Exception e){
                    System.out.println("Falha ao cadastrar usuario " + usuario.getEmail());
                    model.addAttribute("mensagem", "Dados inseridos incorretamente!");
                    return "redirect:/login";
                }
            }
            else if(usuario.isAdmin() && !Objects.equals(usuario.getSenhaAdmin(), "admin123")){
                System.out.println("Falha ao cadastrar usuario " + usuario.getEmail());
                model.addAttribute("mensagem", "Senha de administrador incorreta!");
                return telaCadastro();
            }
            else{
                try {
                    usuarioService.incluir(usuario);
                    model.addAttribute("nomeUsuario", usuario.getNome());
                    model.addAttribute("emailUsuario", usuario.getEmail());
                    System.out.println("Usuario cliente cadastrado com sucesso " + usuario.getEmail());
                    return "redirect:/login";
                } catch (Exception e){
                    System.out.println("Falha ao cadastrar usuario " + usuario.getEmail());
                    model.addAttribute("mensagem", "Dados inseridos incorretamente!");
                    return telaCadastro();
                }
            }
        }else{
            System.out.println("Usuario com este email ja existe " + usuario.getEmail());
            model.addAttribute("mensagem", "Usuario com este email ja existe");
            return telaCadastro();
        }
    }

    @GetMapping(value = "/usuario/{id}/excluir")
    public String excluirUsuario(Model model,@PathVariable Integer id,@SessionAttribute("user") Usuario usuariologado){
        Usuario usuario = usuarioService.obterPorId(id);
        try{
            if(usuario.getId() != null) {
                usuarioService.excluir(id);
                model.addAttribute("mensagem", "O usuário "+usuario.getNome()+" foi excluído com sucesso!!!");
            } else {
                model.addAttribute("mensagem", "Usuário inexistente.. impossível realizar a exclusão!!!");
            }
            if(Objects.equals(usuariologado.getId(), usuario.getId())){
                return "redirect:/logout";
            }
            return telaLista(model);
        }catch (Exception e){
            System.out.println("Falha ao excluir usuario " + usuario.getEmail());
            model.addAttribute("mensagem", "Erro ao excluir usuario " + usuario.getEmail());
            return telaLista(model);
        }
    }
}
