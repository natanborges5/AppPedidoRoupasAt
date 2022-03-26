package br.at.natan.AppPedidoRoupas.Model.Testes;

import br.at.natan.AppPedidoRoupas.Model.Domain.Cliente;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.ClienteService;
import br.at.natan.AppPedidoRoupas.Model.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ClienteLoader implements ApplicationRunner {
    @Autowired
    private ClienteService clienteService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Cliente cliente = new Cliente("rubem","rubem@gmail.com","05505505511");
//        clienteService.incluir(cliente);

    }
}
