package br.at.natan.AppPedidoRoupas.Model.Testes;

import br.at.natan.AppPedidoRoupas.Model.Domain.Calcados;
import br.at.natan.AppPedidoRoupas.Model.Domain.Cliente;
import br.at.natan.AppPedidoRoupas.Model.Execption.ClienteInvalidoEx;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

public class ClienteTeste {
    public static void main(String[] args) {
        try {
            Cliente user = new Cliente("Natan borges","natan@gmail.com","1234567891");
            System.out.println(user);
        } catch (ClienteInvalidoEx e){
            System.out.println(e.getMessage());
        }
    }
}
