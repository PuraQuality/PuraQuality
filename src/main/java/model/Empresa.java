package model;

public class Empresa {
    //Atributos
    private int id;
    private String nome;
    private String setor;
    private String cnpj;

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

    //toString
    public String toString(){
        return "Id: " + id + ", Nome: " + nome + ", Setor: " + setor + ", CNPJ: " + cnpj;
    }
}