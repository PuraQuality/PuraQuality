package model;

import java.sql.Timestamp;

public class HistoricoPagamentos {
    private int id;
    private double valorPago;
    private String formaPagamento;
    private int usuarioId;
    private Timestamp dataPagamento;

//    Getters e Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Timestamp getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Timestamp dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    //    toString

    @Override
    public String toString() {
        return "HistoricoPagamentos{" +
                "id=" + id +
                ", valorPago=" + valorPago +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", usuarioId=" + usuarioId +
                ", dataPagamento=" + dataPagamento +
                '}';
    }
}