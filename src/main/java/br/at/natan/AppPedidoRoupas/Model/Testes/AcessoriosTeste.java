package br.at.natan.AppPedidoRoupas.Model.Testes;

import br.at.natan.AppPedidoRoupas.Model.Domain.Acessorios;
import br.at.natan.AppPedidoRoupas.Model.Domain.Calcados;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

public class AcessoriosTeste {
    public static void main(String[] args) {
        try {
            Acessorios relogio;
            relogio = new Acessorios("Relogio Rolex",200f,20000f,true);
            relogio.setCor("Prata");
            relogio.setMarca("Rolex");
            relogio.setTipo("Relogio de pulso");
            relogio.setModelo("Rolex Aviator x20");
            System.out.println(relogio);
        } catch (ValoresInvalidosEx e){
            System.out.println(e.getMessage());
        }
    }
}
