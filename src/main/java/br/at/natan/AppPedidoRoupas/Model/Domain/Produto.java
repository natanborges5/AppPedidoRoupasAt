package br.at.natan.AppPedidoRoupas.Model.Domain;

import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Float peso;
    private Float valor;
    @Column(length = 500)
    private String imgProduto;
    private boolean regiaoSudesteSul;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @OneToOne(mappedBy = "produtos")
    private Pedidos pedido;

    public Produto() {

    }

    public Produto(String descricao, Float peso, Float valor, Boolean regiaoSudeste) throws ValoresInvalidosEx {
        if(peso < 0) {
            throw new ValoresInvalidosEx("Não foi possivel fazer o cadastro desse produto, insira um valor de peso positivo");
        }
        if(valor <= 0) {
            throw new ValoresInvalidosEx("Não foi possivel fazer o cadastro desse produto, insira um valor positivo");
        }
        if(descricao == null){
            throw new ValoresInvalidosEx("Não foi possivel fazer o cadastro desse produto, insira uma descrição do produto");
        }
        this.descricao = descricao;
        this.peso = peso;
        this.valor = valor;
        this.regiaoSudesteSul = regiaoSudeste;
    }
    public abstract float CalcularFrete();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Descrição:");
        sb.append(descricao);
        sb.append("|Peso:");
        sb.append(peso);
        sb.append("|Valor:");
        sb.append(valor);
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getImgProduto() {
        return imgProduto;
    }

    public void setImgProduto(String imgProduto) {
        this.imgProduto = imgProduto;
    }

    public boolean isRegiaoSudesteSul() {
        return regiaoSudesteSul;
    }

    public void setRegiaoSudesteSul(boolean regiaoSudesteSul) {
        this.regiaoSudesteSul = regiaoSudesteSul;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getPeso() {
        return peso;
    }

    public Float getValor() {
        return valor;
    }

    public boolean isRegiaoSudeste() {
        return regiaoSudesteSul;
    }
}
