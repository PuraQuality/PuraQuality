package repository;

import model.LogAtividade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogAtividadeDao extends Dao<LogAtividade>{

    // CREATE
    public void save(LogAtividade logAtividade) {
//        Comando sql
        String sql = "INSERT INTO log_atividade (ip_usuario, data_hora, descricao, acao, dispositivo, usuario_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazendo a conexao passando comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando
            pstm.setString(1, logAtividade.getIpUsuario());
            pstm.setTimestamp(2, logAtividade.getDataHora());
            pstm.setString(3, logAtividade.getDescricao());
            pstm.setString(4, logAtividade.getAcao());
            pstm.setString(5, logAtividade.getDispositivo());
            pstm.setInt(6, logAtividade.getIdUsuario());

//            Executando
            pstm.executeUpdate();
            System.out.println("Log salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    // UPDATE
    public void update(LogAtividade logAtividade) {
//        Comando sql
        String sql = "UPDATE log_atividade SET ip_usuario = ?, data_hora = ?, descricao = ?, acao = ?, dispositivo = ?, usuario_id = ? " +
                "WHERE id = ?";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazendo conexao e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando
            pstm.setString(1, logAtividade.getIpUsuario());
            pstm.setTimestamp(2, logAtividade.getDataHora());
            pstm.setString(3, logAtividade.getDescricao());
            pstm.setString(4, logAtividade.getAcao());
            pstm.setString(5, logAtividade.getDispositivo());
            pstm.setInt(6, logAtividade.getIdUsuario());
            pstm.setInt(7, logAtividade.getId()); // ID da linha que vai ser atualizada

//            Executando
            pstm.executeUpdate();
            System.out.println("Atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    // DELETE
    public void deleteById(int id) {
//        Comando sql
        String sql = "DELETE FROM log_atividade WHERE id = ?";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazenado a conexao e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Passando o id
            pstm.setInt(1, id);

//            Executando
            pstm.executeUpdate();
            System.out.println("Deletado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando as conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    // READ (SELECT)
    public List<LogAtividade> select() {
//        Criando a lista
        List<LogAtividade> logAtividades = new ArrayList<>();
//        Comando sql
        String sql = "SELECT * FROM log_atividade";

//        Passando null para conn, pstm e rset
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
//            Fazendo a conexao e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
//                Criando objeto para ser armazenado na lista
                LogAtividade logAtividade = new LogAtividade();

//                Instanciando
                logAtividade.setId(rset.getInt("id"));
                logAtividade.setIpUsuario(rset.getString("ip_usuario"));
                logAtividade.setDataHora(rset.getTimestamp("data_hora"));
                logAtividade.setDescricao(rset.getString("descricao"));
                logAtividade.setAcao(rset.getString("acao"));
                logAtividade.setDispositivo(rset.getString("dispositivo"));
                logAtividade.setIdUsuario(rset.getInt("usuario_id"));

//                Adicionando na lista
                logAtividades.add(logAtividade);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }

        return logAtividades;
    }
}