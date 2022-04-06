package br.at.natan.AppPedidoRoupas.Model.Service;

import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public  Collection<Usuario> obterLista(){
        return (Collection<Usuario>) usuarioRepository.findAll();
    }
    public  void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public  Usuario obterPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public  void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario loginUser(String email, String senha) {
        return  usuarioRepository.autenticarUser(email, senha);
    }
    public Usuario obterPorEmail(String email) {
        return  usuarioRepository.obterUserPorEmail(email);
    }
}
