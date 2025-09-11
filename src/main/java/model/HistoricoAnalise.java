package model;

import java.sql.Timestamp;

public class HistoricoAnalise {
    private int id;
    private Timestamp dataHoraGeracao;
    private int respostaId;
    private int producaoId;

//    Getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDataHoraGeracao() {
        return dataHoraGeracao;
    }

    public void setDataHoraGeracao(Timestamp dataHoraGeracao) {
        this.dataHoraGeracao = dataHoraGeracao;
    }

    public int getRespostaId() {
        return respostaId;
    }

    public void setRespostaId(int respostaId) {
        this.respostaId = respostaId;
    }

    public int getProducaoId() {
        return producaoId;
    }

    public void setProducaoId(int producaoId) {
        this.producaoId = producaoId;
    }

//    toString
    public String toString(){
        return "Id: " + id + ", DataHoraGeracao: " + dataHoraGeracao + ", RespostaId: " + respostaId + ", producaoId: " + producaoId;
    }
}