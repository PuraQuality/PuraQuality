package com.model;

public class Funcionario {

    //Atributos
    private int id;
    private String email;
    private String senha;
    private int empresaId;
    private boolean prioridade;

    //Construtor
    public Funcionario() {

    }

    public Funcionario(int id,String email, String senha, boolean prioridade) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.prioridade = prioridade;
    }

    public Funcionario(String email, String senha, int empresaId, boolean prioridade) {
        this.email = email;
        this.senha = senha;
        this.empresaId = empresaId;
        this.prioridade = prioridade;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    //toString
    public String toString(){
        return "Id: " + id + ", Email: " + email + ", Senha: " + senha + ", Prioridade: " + prioridade;
    }
}