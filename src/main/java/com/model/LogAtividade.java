package com.model;

import java.sql.Timestamp;


public class LogAtividade {
    private int id;
    private String ipUsuario;
    private Timestamp dataHora;
    private String descricao;
    private String acao;
    private String dispositivo;
    private int idUsuario;

//    Getters e Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

//    toString

    public String toString(){
        return "Id: " + id + ", IpUsuário: " + ipUsuario + ", DataHora: " + dataHora + ", Descrição: " + descricao + ", Ação: " + acao + ", Dispositivo: " + dispositivo + ", IdUsuário: " + idUsuario;
    }
}