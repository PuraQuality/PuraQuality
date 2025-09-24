package com.repository;

import com.conexao.ConnectionFactory;
import com.model.HistoricoAnalise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoricoAnaliseDao extends Dao<HistoricoAnalise>{

    public void save(HistoricoAnalise historicoAnalise) {
//        Comando sql
        String sql = "INSERT INTO historico_analise (data_hora_geracao, resposta_id, producao_id) VALUES (?,?,?)";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
//            Fazendo conexoes e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando
            pstm.setTimestamp(1, historicoAnalise.getDataHoraGeracao());
            pstm.setInt(2, historicoAnalise.getRespostaId());
            pstm.setInt(3, historicoAnalise.getProducaoId());

//            Executando
            pstm.execute();
            System.out.println("Salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void update(HistoricoAnalise historicoAnalise) {
//        Comando sql
        String sql = "UPDATE historico_analise SET data_hora_geracao = ?, resposta_id = ?, producao_id = ? WHERE id = ?";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazendo conexao e passando comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando
            pstm.setTimestamp(1, historicoAnalise.getDataHoraGeracao());
            pstm.setInt(2, historicoAnalise.getRespostaId());
            pstm.setInt(3, historicoAnalise.getProducaoId());
            pstm.setInt(4, historicoAnalise.getId());

//            Executando
            pstm.execute();
            System.out.println("Salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void deleteById(int id) {
//        Comando sql
        String sql = "DELETE FROM historico_analise WHERE id = ?";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazendo conexao e passando comando
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Passando ID
            pstm.setInt(1, id);

//            Executando
            pstm.execute();
            System.out.println("Deletado com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public List<HistoricoAnalise> select() {
//        Criando a lista do historico de analise
        List<HistoricoAnalise> historicoAnalises = new ArrayList<HistoricoAnalise>();

//        Comando sql
        String sql = "SELECT * FROM historico_analise";

//        Passando null para conn, pstm e rset
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
//            Fazendo conexao e passando comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
//                Criando o objeto para ser armazenado na lista
                HistoricoAnalise historicoAnalise = new HistoricoAnalise();

//                Instanciando
                historicoAnalise.setId(rset.getInt("id"));
                historicoAnalise.setDataHoraGeracao(rset.getTimestamp("data_hora_geracao"));
                historicoAnalise.setRespostaId(rset.getInt("resposta_id"));
                historicoAnalise.setProducaoId(rset.getInt("producao_id"));

//                Adicionando objeto a lista
                historicoAnalises.add(historicoAnalise);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }
        return historicoAnalises;
    }
}