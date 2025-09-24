package com.model;

public class UsuarioEmpresa {
    //Atributos
    private int usuarioId;
    private int empresaId;

    //Getters
    public int getUsuarioId() {
        return usuarioId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    //Setters
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    //toString
    public String toString(){
        return "Usuario_id: " + usuarioId + ", Empresa_id: " + empresaId;
    }
}