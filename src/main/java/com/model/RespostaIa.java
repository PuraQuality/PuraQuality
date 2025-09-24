package com.model;

import java.sql.Timestamp;

public class RespostaIa {
    //Atributos
    private int id;
    private Timestamp data;
    private String textoGerado;
    private int producaoId;

    //    Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public String getTextoGerado() {
        return textoGerado;
    }

    public void setTextoGerado(String textoGerado) {
        this.textoGerado = textoGerado;
    }

    public int getProducaoId() {
        return producaoId;
    }

    public void setProducaoId(int producaoId) {
        this.producaoId = producaoId;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    //    toString
    public String toString(){
        return "Id: " + id + ", Data: " + data + ", Texto gerado: " + textoGerado + ", ProduçãoId: " + producaoId;
    }
}