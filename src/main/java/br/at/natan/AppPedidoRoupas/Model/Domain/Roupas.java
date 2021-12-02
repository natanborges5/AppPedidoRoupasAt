package br.at.natan.AppPedidoRoupas.Model.Domain;

public class Roupas extends Produto {
    private String marca;
    private String modelo;
    private String tamanho;
    private String tipo;
    private String cor;
    private String material;

    public Roupas(String descricao, String peso, Float valor) {
        super(descricao, peso, valor);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(marca);
        sb.append(";");
        sb.append(modelo);
        sb.append(";");
        sb.append(tamanho);
        sb.append(";");
        sb.append(tipo);
        sb.append(";");
        sb.append(cor);
        sb.append(";");
        sb.append(material);
        return sb.toString();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
