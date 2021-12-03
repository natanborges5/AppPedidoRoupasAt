package br.at.natan.AppPedidoRoupas.Model.Testes;
import br.at.natan.AppPedidoRoupas.Model.Domain.*;
import br.at.natan.AppPedidoRoupas.Model.Execption.ClienteInvalidoEx;
import br.at.natan.AppPedidoRoupas.Model.Execption.PedidosInvalidosEx;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PedidoArkTeste {
    public static void main(String[] args) {
        try {

            String arquivo = "PedidoLojaRoupas.txt";

            FileReader fileR = new FileReader(arquivo);
            BufferedReader leitura = new BufferedReader(fileR);

            FileWriter fileW = new FileWriter("out_"+arquivo);
            BufferedWriter escrita = new BufferedWriter(fileW);

            String linha = leitura.readLine();

            String[] campos = null;

            List<Produto> listaPedido = new ArrayList<Produto>();

            Pedido pedido = null;

            while(linha != null) {
                campos = linha.split(";");

                String tipo = campos[0];
                switch (tipo.toUpperCase()) {
                    case "Cliente":
                        Cliente user = null;
                        try {
                            user = new Cliente("Natan borges","natan@gmail.com","1234567891");
                        } catch (ClienteInvalidoEx e){
                            System.out.println(e.getMessage());
                        }
                        try {
                            pedido = new Pedido(user);
                            pedido.setDescricao("Pedido do cliente "+user.getNome());
                            pedido.setProdutos(listaPedido);

                            System.out.println(user);
                            pedido.ImprimirPedidos();
                        } catch (ClienteInvalidoEx | PedidosInvalidosEx e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Roupas":
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
                        break;
                    case "Acessorios":
                        try {
                            Acessorios relogio = new Acessorios("Relogio Rolex",200f,20000f,false);
                            relogio.setCor("Prata");
                            relogio.setMarca("Rolex");
                            relogio.setModelo("Rolex Aviator x20");
                            listaPedido.add(relogio);
                        } catch (ValoresInvalidosEx e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Calçados":
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
                        break;
                    default:
                        System.out.println("Tipo inválido: " + tipo);
                        break;
                }
                linha = leitura.readLine();
            }
            try {
                pedido.ImprimirPedidos();
                escrita.write(pedido.obterLinhaGravacaoArquivo());
            } catch (PedidosInvalidosEx e) {
                System.out.println(e.getMessage());
            }
            leitura.close();
            escrita.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
