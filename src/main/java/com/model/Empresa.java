package com.model;

public class Empresa {
    //Atributos
    private int id;
    private String nome;
    private String setor;
    private String cnpj;
    private String email;
    private String senha;
    private int planoId;
    private String plano;


    public Empresa(){

    }

    public Empresa(int id,String nome, String setor, String cnpj, String email, String senha, int planoId) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.planoId = planoId;
        this.plano = (planoId == 10)?"Quality":(planoId==11)?"FullQuality":"PuraQuality";
    }

    public Empresa(String nome, String setor, String cnpj, String email, String senha, int planoId) {
        this.nome = nome;
        this.setor = setor;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.planoId = planoId;
        this.plano = (planoId == 10)?"Quality":(planoId==11)?"FullQuality":"PuraQuality";
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getPlanoId() {
        return planoId;
    }

    public String getPlano() {
        return plano;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPlanoId(int planoId) {
        this.planoId = planoId;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    //toString
    public String toString(){
        return "Id: " + id + ", Nome: " + nome + ", Setor: " + setor + ", CNPJ: " + cnpj +
                ", Email: " + email + ", Senha: " + senha + ", Plano: " + planoId;
    }
}