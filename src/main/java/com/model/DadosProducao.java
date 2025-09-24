package com.model;

import java.sql.Time;
import java.sql.Timestamp;

public class DadosProducao {
    //Atributos
    private int id;
    private String descricao;
    private Timestamp dataEnvio;
    private int empresaId;
    private int usuarioId;

    //Getters
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Timestamp getDataEnvio() {
        return dataEnvio;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataEnvio(Timestamp dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    //toString
    public String toString(){
        return "Id: " + id + ", Descrição: " + descricao + ", Data_envio: " + dataEnvio + ", Empresa_id: " + empresaId + ", Usuario: " + usuarioId;
    }
}