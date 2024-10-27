package com.mychanic.models;

import java.util.Date;

public class Admin{
    private String nome;
    private String email;
    private String cargo;
    private Date dataAdmissao;

    public Admin(){}
    public Admin(String nome, String cargo){
        this.nome = nome;
        this.cargo = cargo;
    }
    public Admin(String nome, String email, String cargo, Date dataAdmissao) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
    }

    public Admin(String login, String senha, String nome, String email, String cargo, Date dataAdmissao) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
    }

    public String getNome() {
        return nome;
    }

    public Admin setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Admin setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCargo() {
        return cargo;
    }

    public Admin setCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public Admin setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
        return this;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                '}';
    }
}