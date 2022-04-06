package br.at.natan.AppPedidoRoupas.Model.Repository;

import br.at.natan.AppPedidoRoupas.Model.Domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends CrudRepository <Usuario, Integer> {
    @Query("select u from Usuario u where u.Email = :email and u.Senha = :senha")
     Usuario autenticarUser(String email, String senha);
    @Query("select u from Usuario u where u.Email = :email")
    Usuario obterUserPorEmail(String email);
}
