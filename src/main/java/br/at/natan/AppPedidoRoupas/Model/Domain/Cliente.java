package br.at.natan.AppPedidoRoupas.Model.Domain;

import br.at.natan.AppPedidoRoupas.Model.Execption.ClienteInvalidoEx;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpf;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

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

    public String getSenha() {
        return senha;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
