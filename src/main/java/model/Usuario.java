package model;

public class Usuario {

    //Atributos
    private int id;
    private String email;
    private String senha;
    private int planoId;

    //Getters
    public int getId() {
        return id;
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

    //Setters
    public void setId(int id) {
        this.id = id;
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

    //toString
    public String toString(){
        return "Id: " + id + ", Email: " + email + ", Senha: " + senha + ", plano_id: " + planoId;
    }
}