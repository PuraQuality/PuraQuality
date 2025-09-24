package com.repository;

//package
import com.conexao.ConnectionFactory;
import com.model.Feedback;

//sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//util
import java.util.ArrayList;
import java.util.List;

public class FeedbackDao {

    public void save(Feedback feedback) {

//        Comando sql
        String sql = "INSERT INTO feedback (nota, comentario, usuario_id, resposta_id) VALUES (?, ?, ?, ?)";

//        Atribuindo null para o conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Fazendo a conexao e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando
            pstm.setDouble(1, feedback.getNota());
            pstm.setString(2, feedback.getComentario());
            pstm.setInt(3, feedback.getUsuarioId());
            pstm.setInt(4, feedback.getRespostaId());

//            Executando
            pstm.execute();
            System.out.println("Salvo com sucesso");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void update(Feedback feedback) {
//        Comando sql
        String sql = "UPDATE feedback SET nota = ?, comentario = ?, usuario_id = ?, resposta_id = ? WHERE id = ?";

//        Passando null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazendo a conexao e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando
            pstm.setDouble(1, feedback.getNota());
            pstm.setString(2, feedback.getComentario());
            pstm.setInt(3, feedback.getUsuarioId());
            pstm.setInt(4, feedback.getRespostaId());
            pstm.setInt(5, feedback.getId());

//            Executando
            pstm.execute();
            System.out.println("salvo com sucesso");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void deleteById(int id) {
//        Comando sql
        String sql = "DELETE FROM feedback WHERE id = ?";

//        Passando null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazendo a conexao e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Passando o ID
            pstm.setInt(1, id);

//            Executando
            pstm.execute();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public List<Feedback> select() {
//        Criando a lista do Feedback
        List<Feedback> feedbacks = new ArrayList<Feedback>();
//        Comando sql
        String sql = "SELECT * FROM feedback";

//        Atribuindo null para conn, pstm e rset
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
//            Fazendo a conexão e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
//                Criando o objeto para ser armazenado na lista
                Feedback feedback = new Feedback();

//                Instanciando
                feedback.setId(rset.getInt("id"));
                feedback.setNota(rset.getDouble("nota"));
                feedback.setComentario(rset.getString("comentario"));
                feedback.setUsuarioId(rset.getInt("usuario_id"));
                feedback.setRespostaId(rset.getInt("resposta_id"));

                feedbacks.add(feedback);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }
        return feedbacks;
    }
}