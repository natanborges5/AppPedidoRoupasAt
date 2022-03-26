package br.at.natan.AppPedidoRoupas.Model.Service;

import br.at.natan.AppPedidoRoupas.Model.Domain.Cliente;
import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import br.at.natan.AppPedidoRoupas.Model.Repository.ClienteRepository;
import br.at.natan.AppPedidoRoupas.Model.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public Collection<Cliente> obterLista(){
        return (Collection<Cliente>) clienteRepository.findAll();
    }
    public  void incluir(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public  Cliente obterPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public  void excluir(Integer id) {
        clienteRepository.deleteById(id);
    }
}
