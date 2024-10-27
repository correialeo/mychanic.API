package com.mychanic.models;

public class Diagnostico {

    private String requisicao;
    private String resposta;

    public Diagnostico(){}

    public Diagnostico(String requisicao, String resposta) {
        this.requisicao = requisicao;
        this.resposta = resposta;
    }

    public String getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(String requisicao) {
        this.requisicao = requisicao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "requisicao='" + requisicao + '\'' +
                ", resposta='" + resposta + '\'' +
                '}';
    }
}
