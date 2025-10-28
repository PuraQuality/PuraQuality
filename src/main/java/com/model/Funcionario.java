package com.model;

public class Funcionario {

    //Atributos
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private int telefone;
    private int empresaId;
    private boolean prioridade;

    //Construtor
    public Funcionario() {

    }

    public Funcionario(int id, String nome, String sobrenome, int telefone, String email, String senha, boolean prioridade) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.prioridade = prioridade;
    }

    public Funcionario(String nome, String sobrenome, int telefone, String email, String senha, int empresaId, boolean prioridade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.empresaId = empresaId;
        this.prioridade = prioridade;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getTelefone() {
        return telefone;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
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
        return "Id: " + id + "Nome: " + nome + "Sobrenome: " + sobrenome + ", Email: " + email + ", Senha: " + senha + ", Prioridade: " + prioridade;
    }
}