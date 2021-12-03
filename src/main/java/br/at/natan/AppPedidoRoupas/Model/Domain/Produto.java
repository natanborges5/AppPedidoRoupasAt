package br.at.natan.AppPedidoRoupas.Model.Domain;

import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

public abstract class Produto {
    private String descricao;
    private Float peso;
    private Float valor;
    private boolean regiaoSudesteSul;

    public Produto(String descricao, Float peso, Float valor, Boolean regiaoSudeste) throws ValoresInvalidosEx {
        if(peso <= 0) {
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
