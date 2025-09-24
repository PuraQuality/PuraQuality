package com.repository;

//package
import com.model.DadosProducao;


//sql
import java.sql.*;

//pacote util
import java.util.ArrayList;
import java.util.List;

public class DadosProducaoDao extends Dao<DadosProducao>{

    public void save(DadosProducao dadosProducao){

        //Código sql
        String sql = "INSERT INTO dados_producao (descricao, data_envio, empresa_id, usuario_id) VALUES (?, ?, ?, ?)";

        //Atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Fazendo a conexão e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando o pstm
            pstm.setString(1,dadosProducao.getDescricao());
            pstm.setTimestamp(2, new Timestamp(dadosProducao.getDataEnvio().getTime()));
            pstm.setInt(3,dadosProducao.getEmpresaId());
            pstm.setInt(4,dadosProducao.getUsuarioId());

            //Executando
            pstm.execute();
            System.out.println("Salvo com sucesso!");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public List<DadosProducao> select(){

        //Criando lista das producoes
        List<DadosProducao> dadosProducoes = new ArrayList<DadosProducao>();

        //Comando sql
        String sql = "SELECT * FROM dados_producao";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Fazendo a conexão e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();


            while(rset.next()){
                //Criando o objeto para ser armazenado na lista
                DadosProducao dadosProducao = new DadosProducao();

                //Instanciando
                dadosProducao.setId(rset.getInt("id"));
                dadosProducao.setDescricao(rset.getString("descricao"));
                dadosProducao.setDataEnvio(rset.getTimestamp("data_envio"));
                dadosProducao.setEmpresaId(rset.getInt("empresa_id"));
                dadosProducao.setUsuarioId(rset.getInt("usuario_id"));

                dadosProducoes.add(dadosProducao);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }
        return dadosProducoes;
    }

    public void update(DadosProducao dadosProducao){
        //Comando sql
        String sql = "UPDATE dados_producao SET descricao = ?, data_envio = ?, empresa_id = ?, usuario_id = ? WHERE id = ?";

        //Atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Fazendo conexão e passando comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando o pstm
            pstm.setString(1,dadosProducao.getDescricao());
            pstm.setTimestamp(2,dadosProducao.getDataEnvio());
            pstm.setInt(3,dadosProducao.getEmpresaId());
            pstm.setInt(4,dadosProducao.getUsuarioId());
            pstm.setInt(5,dadosProducao.getId());

            //Executando comando sql
            pstm.execute();
            System.out.println("Salvo com sucesso!");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void deleteById(int id){

        //Comando sql
        String sql = "DELETE FROM dados_producao WHERE id = ?";

        //Atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Fazendo a conexão e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Passando o id
            pstm.setInt(1,id);

            //Executando
            pstm.execute();
            System.out.println("Deletado com sucesso!");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }
}