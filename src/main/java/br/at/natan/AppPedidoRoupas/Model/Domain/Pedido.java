package br.at.natan.AppPedidoRoupas.Model.Domain;

import br.at.natan.AppPedidoRoupas.Model.Execption.ClienteInvalidoEx;
import br.at.natan.AppPedidoRoupas.Model.Execption.PedidosInvalidosEx;
import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Pedido {
    private String descricao;
    private LocalDateTime data;
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido(Cliente cliente) throws ClienteInvalidoEx {
        if(cliente == null){
            throw new ClienteInvalidoEx("Não foi possivel criar o pedido, o cliente não foi cadastrado");
        }
        this.descricao = "descricao";
        this.data = LocalDateTime.now();
        this.cliente = cliente;
    }
    public void ImprimirPedidos() throws PedidosInvalidosEx {
        if (produtos == null){
            throw new PedidosInvalidosEx("A lista de pedidos esta nula");
        }
        if (produtos.size() == 0){
            throw new PedidosInvalidosEx("Não existe nenhum pedido na lista");
        }
        int contador = 1;
        System.out.println("///////////////////Pedidos///////////////////");
        for(Produto produto : produtos){
            System.out.println("Pedido numero: "+contador+ " - "+ produto);
            contador++;
        }
        System.out.println("Valor total do carrinho: "+ CalcularTotalCarrinho());
    }
    public Float CalcularTotalCarrinho(){
        float contador = 0;
        for(Produto produto : produtos){
            float frete = 0;
            if(!produto.isRegiaoSudeste()){
                frete = produto.CalcularFrete();
            }
            contador = contador + produto.getValor() + frete;

        }
        return contador;
    }


    @Override
    public String toString() {
        int qntdProduto = 0;
        if(produtos.size() > 0)
            qntdProduto = produtos.size();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("%s;%s;%s;%d",this.descricao,this.data.format(formatter),this.cliente,qntdProduto);
    }

    public String getDescricao() {
        return descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String obterLinhaGravacaoArquivo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Descrição:");
        sb.append(descricao);
        sb.append("|Nome:");
        sb.append(cliente.getNome());
        sb.append("|Quantidade de produtos:");
        sb.append(produtos.size());
		sb.append("|Valor total do carrinho:");
		sb.append(CalcularTotalCarrinho());
        sb.append("\r\n");
        return sb.toString();
    }
}
