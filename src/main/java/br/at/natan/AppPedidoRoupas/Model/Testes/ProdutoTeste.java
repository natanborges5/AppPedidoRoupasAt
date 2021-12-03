package br.at.natan.AppPedidoRoupas.Model.Testes;

import br.at.natan.AppPedidoRoupas.Model.Domain.Acessorios;
import br.at.natan.AppPedidoRoupas.Model.Domain.Calcados;
import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

public class ProdutoTeste {
    public static void main(String[] args) {
        try {
            Roupas blusaCK;
            blusaCK = new Roupas("blusaCvk",200f,50f,true);
            blusaCK.setCor("Azul");
            blusaCK.setMarca("Calvin Klein");
            blusaCK.setMaterial("Lã");
            blusaCK.setTamanho("M");
            blusaCK.setModelo("Blusa verão 2021");
            blusaCK.setTipo("Blusa");
            System.out.println(blusaCK);
        } catch (ValoresInvalidosEx e){
            System.out.println(e.getMessage());
        }
        try {
            Acessorios relogio;
            relogio = new Acessorios("Relogio Rolex",200f,20000f,true);
            relogio.setCor("Prata");
            relogio.setMarca("Rolex");
            relogio.setModelo("Rolex Aviator x20");
            System.out.println(relogio);
        } catch (ValoresInvalidosEx e){
            System.out.println(e.getMessage());
        }
        try {
            Calcados tenisNike;
            tenisNike = new Calcados("Tenis Nike",200f,300f,true);
            tenisNike.setCor("Preto");
            tenisNike.setMarca("Nike");
            tenisNike.setTamanho(40);
            tenisNike.setModelo("Basqueteira Nike");
            System.out.println(tenisNike);
        } catch (ValoresInvalidosEx e){
            System.out.println(e.getMessage());
        }

    }
}
