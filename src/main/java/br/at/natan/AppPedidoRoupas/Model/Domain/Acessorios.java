package br.at.natan.AppPedidoRoupas.Model.Domain;

public class Acessorios extends Produto {
    private String modelo;
    private String marca;
    private String tipo;
    private String cor;

    public Acessorios(String descricao, String peso, Float valor) {
        super(descricao, peso, valor);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(modelo);
        sb.append(";");
        sb.append(marca);
        sb.append(";");
        sb.append(tipo);
        sb.append(";");
        sb.append(cor);
        return sb.toString();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
}
