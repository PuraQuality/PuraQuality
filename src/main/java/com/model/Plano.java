package com.model;

public class Plano {
    //Atributos
    private int id;
    private String nome;
    private double preco;
    private int limiteFuncionalidades;

    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getLimiteFuncionalidades() {
        return limiteFuncionalidades;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setLimiteFuncionalidades(int limiteFuncionalidades) {
        this.limiteFuncionalidades = limiteFuncionalidades;
    }

    //toString
    public String toString(){
        return "Id: "+ id + ", Nome: " + nome + ", Preço: " + preco + ", Limite de Funcionalidades: " + limiteFuncionalidades;
    }
}