package br.at.natan.AppPedidoRoupas.Model.Testes;

import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoader implements ApplicationRunner {
    @Autowired
    private UsuarioService usuarioService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Usuario usuario = new Usuario();
//        usuario.setNome("rubem");
//        usuario.setEmail("rubem@gmail.com");
//        usuario.setSenha("123451");
//
//        usuarioService.incluir(usuario);
    }
}
