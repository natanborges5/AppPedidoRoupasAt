package br.at.natan.AppPedidoRoupas.Model.Testes;

import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

public class RoupasTeste {
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
    }
}
