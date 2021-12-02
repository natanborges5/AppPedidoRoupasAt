package br.at.natan.AppPedidoRoupas.Model.Domain;

public abstract class Produto {
    private String descricao;
    private String peso;
    private Float valor;

    public Produto(String descricao, String peso, Float valor) {
        this.descricao = descricao;
        this.peso = peso;
        this.valor = valor;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(descricao);
        sb.append(";");
        sb.append(peso);
        sb.append(";");
        sb.append(valor);
        return sb.toString();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPeso() {
        return peso;
    }

    public Float getValor() {
        return valor;
    }

}
