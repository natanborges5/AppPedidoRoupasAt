package br.at.natan.AppPedidoRoupas.Model.Domain;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Pedido {
    private String descricao;
    private LocalDateTime data;
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido() {
        this.descricao = "descricao";
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("%s;%s;%s;%d",this.descricao,this.data.format(formatter),this.cliente,this.produtos.size());
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
}
