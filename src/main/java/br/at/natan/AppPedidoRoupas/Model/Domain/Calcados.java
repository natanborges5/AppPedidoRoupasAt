package br.at.natan.AppPedidoRoupas.Model.Domain;

import br.at.natan.AppPedidoRoupas.Model.Execption.ValoresInvalidosEx;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TCalcado")
public class Calcados extends Produto {
    private String modelo;
    private String marca;
    private Integer tamanho;
    private String cor;
    private String material;
    public Calcados(){

    }
    public Calcados(String descricao, Float peso, Float valor,Boolean regiao) throws ValoresInvalidosEx {
        super(descricao, peso, valor,regiao);
    }

    @Override
    public float CalcularFrete() {
         if(this.isRegiaoSudeste()){
             return 0;
         } else return this.getPeso() * 0.03f;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("|Modelo:");
        sb.append(modelo);
        sb.append("|Marca:");
        sb.append(marca);
        sb.append("|Tamanho");
        sb.append(tamanho);
        sb.append("|Cor");
        sb.append(cor);
        sb.append("|Valor do frete:");
        sb.append(CalcularFrete());
        return sb.toString();
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws ValoresInvalidosEx {
        if(modelo == null) {
            throw new ValoresInvalidosEx("Não foi possivel fazer o cadastro desse produto, insira o modelo do produto");
        }
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws ValoresInvalidosEx {
        if(marca == null) {
            throw new ValoresInvalidosEx("Não foi possivel fazer o cadastro desse produto, insira a marca do produto");
        }
        this.marca = marca;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) throws ValoresInvalidosEx {
        if(tamanho == null) {
            throw new ValoresInvalidosEx("Não foi possivel fazer o cadastro desse produto, insira o tamanho do produto");
        }
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) throws ValoresInvalidosEx {
        if(cor == null) {
            throw new ValoresInvalidosEx("Não foi possivel fazer o cadastro desse produto, insira a cor do produto");
        }
        this.cor = cor;
    }
}
