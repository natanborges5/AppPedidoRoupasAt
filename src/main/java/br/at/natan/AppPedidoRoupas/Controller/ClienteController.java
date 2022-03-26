package br.at.natan.AppPedidoRoupas.Controller;

import br.at.natan.AppPedidoRoupas.Model.Domain.Cliente;
import br.at.natan.AppPedidoRoupas.Model.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class ClienteController {

    @GetMapping(value = "/cliente")
    public String telaCadastro() {
        return "cliente/cadastro";
    }

    @GetMapping(value = "/clientes")
    public String telaLista() {

        return "cliente/lista";
    }

    @PostMapping(value = "/cliente/incluir")
    public String incluir(Cliente cliente, Model model){
        model.addAttribute("mensagem", "O aluno " + cliente.getNome() + " foi incluído com sucesso!!!");
        return telaLista();
    }
}
