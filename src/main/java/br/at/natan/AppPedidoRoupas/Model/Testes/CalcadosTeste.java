package br.at.natan.AppPedidoRoupas.Model.Testes;

import br.at.natan.AppPedidoRoupas.Model.Domain.Calcados;
import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

public class CalcadosTeste {
    public static void main(String[] args) {
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
