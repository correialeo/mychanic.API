package com.mychanic.models;

import java.sql.Time;

public class Oficina {
    private int id;
    private String nome;
    private String endereco;
    private String email;
    private String horarioFunc;
    private Integer avaliacao;
    private Integer categoria;

    public Oficina(){}

    public Oficina(int id, String nome, String endereco, String email, String horarioFunc, Integer avaliacao, Integer categoria) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.horarioFunc = horarioFunc;
        this.avaliacao = avaliacao;
        this.categoria = categoria;
    }

    public Oficina(String nome, String endereco, String email, String horarioFunc, Integer avaliacao, Integer categoria) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.horarioFunc = horarioFunc;
        this.avaliacao = avaliacao;
        this.categoria = categoria;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorarioFunc() {
        return horarioFunc;
    }

    public void setHorarioFunc(String horarioFunc) {
        this.horarioFunc = horarioFunc;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }
}
