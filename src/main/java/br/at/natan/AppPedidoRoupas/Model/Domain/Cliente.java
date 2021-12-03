package br.at.natan.AppPedidoRoupas.Model.Domain;

import br.at.natan.AppPedidoRoupas.Model.Execption.ClienteInvalidoEx;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;

    public Cliente(String nome, String email, String cpf) throws ClienteInvalidoEx {
        if(nome == null){
            throw new ClienteInvalidoEx("O nome do Cliente esta nulo!!");
        }
        if(email == null){
            throw new ClienteInvalidoEx("O email do Cliente "+nome+" esta nulo!!");
        }
        if(cpf == null){
            throw new ClienteInvalidoEx("O cpf do Cliente "+nome+" esta nulo!!");
        }
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do cliente:");
        sb.append(nome);
        sb.append("|Email:");
        sb.append(email);
        sb.append("|CPF:");
        sb.append(cpf);
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
