package br.at.natan.AppPedidoRoupas.Model.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TUsuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nome;
    private String Email;
    private String Senha;
    private String Telefone;
    private boolean admin;
    private String senhaAdmin;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idusuario")
    private List<Produto> produtos;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idusuario")
    private List<Pedidos> pedidos;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idendereco")
    private Endereco endereco;

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

    public void setSenhaAdmin(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
