package com.mychanic.models;

public class ServiceResponse<T> {
    private boolean success;
    private T data;
    private String mensagem;

    public ServiceResponse(boolean success, T data, String mensagem) {
        this.success = success;
        this.data = data;
        this.mensagem = mensagem;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public static <T> ServiceResponse<T> success (T data, String mensagem){
        return new ServiceResponse<>(true, data, mensagem);
    }

    public static <T> ServiceResponse<T> failure (String mensagem){
        return new ServiceResponse<>(false, null, mensagem);
    }
}
