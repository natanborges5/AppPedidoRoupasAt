package br.at.natan.AppPedidoRoupas.Model.Domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TPedido")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private LocalDateTime data;

    @OneToOne(cascade = CascadeType.DETACH)
    private Produto produtos;


    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public Pedidos() {
        this.descricao = "Pedido padrão da empresa";
        this.data = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public String getDescricao() {
        return descricao;
    }


    public LocalDateTime getData() {
        return data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String obterLinhaGravacaoArquivo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Descrição:");
        sb.append(descricao);
        sb.append("|Nome:");
        sb.append("|Quantidade de produtos:");
        sb.append("\r\n");
        return sb.toString();
    }

}
