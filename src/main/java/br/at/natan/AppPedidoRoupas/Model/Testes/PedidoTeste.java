package br.at.natan.AppPedidoRoupas.Model.Testes;

import br.at.natan.AppPedidoRoupas.Model.Domain.*;
import br.at.natan.AppPedidoRoupas.Model.Execption.ClienteInvalidoEx;
import br.at.natan.AppPedidoRoupas.Model.Execption.PedidosInvalidosEx;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

import java.util.ArrayList;
import java.util.List;

public class PedidoTeste {
    public static void main(String[] args) {
        List<Produto> listaPedido = new ArrayList<Produto>();
        try {
            Roupas blusaCK = new Roupas("blusaCvk",200f,50f,true);
            blusaCK.setCor("Azul");
            blusaCK.setMarca("Calvin Klein");
            blusaCK.setMaterial("Lã");
            blusaCK.setTamanho("M");
            blusaCK.setModelo("Blusa verão 2021");
            blusaCK.setTipo("Blusa");
            listaPedido.add(blusaCK);
        } catch (ValoresInvalidosEx e){
            System.out.println(e.getMessage());
        }
        try {
            Acessorios relogio = new Acessorios("Relogio Rolex",200f,20000f,false);
            relogio.setCor("Prata");
            relogio.setMarca("Rolex");
            relogio.setModelo("Rolex Aviator x20");
            listaPedido.add(relogio);
        } catch (ValoresInvalidosEx e){
            System.out.println(e.getMessage());
        }
        try {
            Calcados tenisNike = new Calcados("Tenis Nike",1000f,300f,false);
            tenisNike.setCor("Preto");
            tenisNike.setMarca("Nike");
            tenisNike.setTamanho(40);
            tenisNike.setModelo("Basqueteira Nike");
            listaPedido.add(tenisNike);
        } catch (ValoresInvalidosEx e){
            System.out.println(e.getMessage());
        }
        Cliente user = null;
        try {
            user = new Cliente("Natan borges","natan@gmail.com","1234567891");
        } catch (ClienteInvalidoEx e){
            System.out.println(e.getMessage());
        }
        try {
            Pedido pedido = new Pedido(user);
            pedido.setDescricao("Pedido do cliente "+user.getNome());
            pedido.setProdutos(listaPedido);

            System.out.println(user);
            pedido.ImprimirPedidos();
        } catch (ClienteInvalidoEx | PedidosInvalidosEx e){
            System.out.println(e.getMessage());
        }
    }
}
