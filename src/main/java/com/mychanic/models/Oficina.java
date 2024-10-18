package com.mychanic.models;

import java.sql.Time;

public class Oficina {
    private long id;
    private String nome;
    private String endereco;
    private String email;
    private Time horarioFunc;
    private Integer avaliacao;
    private Integer categoria;

    public Oficina(){}

    public Oficina(long id, String nome, String endereco, String email, Time horarioFunc, Integer avaliacao, Integer categoria) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.horarioFunc = horarioFunc;
        this.avaliacao = avaliacao;
        this.categoria = categoria;
    }

    public Oficina(String nome, String endereco, String email, Time horarioFunc, Integer avaliacao, Integer categoria) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Time getHorarioFunc() {
        return horarioFunc;
    }

    public void setHorarioFunc(Time horarioFunc) {
        this.horarioFunc = horarioFunc;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }
}
