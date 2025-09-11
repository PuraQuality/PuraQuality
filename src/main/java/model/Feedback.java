package model;

public class Feedback {
    //Atributos
    private int id;
    private double nota;
    private String comentario;
    private int usuarioId;
    private int respostaId;

//    Getters
    public int getId() {
        return id;
    }

    public int getRespostaId() {
        return respostaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public double getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }
//      Setters
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setRespostaId(int respostaId) {
        this.respostaId = respostaId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    //    toString
    public String toString() {
        return "Id: " + id + ", Nota: " + nota + ", Comentario: " + comentario + ", Usuario_id: " + usuarioId + ", Resposta_id: " + respostaId;
    }
}