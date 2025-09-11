package dao;

import model.RespostaIa;

//sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

//util
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RespostaIaDao {
    public void save(RespostaIa respostaIa) {
//        Comando sql
        String sql = "INSERT INTO resposta_ia (data_hora_geracao, texto_gerado, producao_id) VALUES (?,?,?)";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//           Fazendo a conexao e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando
            pstm.setTimestamp(1,new Timestamp(respostaIa.getData().getTime()));
            pstm.setString(2, respostaIa.getTextoGerado());
            pstm.setInt(3, respostaIa.getProducaoId());

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

    public void update(RespostaIa respostaIa) {
//        Comando sql
        String sql = "UPDATE resposta_ia SET data_hora_geracao = ?, texto_gerado = ?, producao_id = ? WHERE id = ?";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazendo conexao e passando comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando
            pstm.setTimestamp(1, new Timestamp(respostaIa.getData().getTime()));
            pstm.setString(2, respostaIa.getTextoGerado());
            pstm.setInt(3, respostaIa.getProducaoId());
            pstm.setInt(4, respostaIa.getId());

//            Executando
            pstm.execute();
            System.out.println("Salvo com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void deleteById(int id) {
//        Comando sql
        String sql = "DELETE FROM resposta_ia WHERE id = ?";

//        Passando null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
//            Fazendo a conexao e passado o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Passando o id
            pstm.setInt(1, id);

            pstm.execute();
            System.out.println("Deletado com sucesso");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public List<RespostaIa> select() {
//        Criando lista da resposta da IA
        List<RespostaIa> respostaIa = new ArrayList<RespostaIa>();

//        Comando sql
        String sql = "SELECT * FROM resposta_ia";

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
                RespostaIa resp = new RespostaIa();

//                Instanciando
                resp.setId(rset.getInt("id"));
                resp.setData(rset.getTimestamp("data_hora_geracao"));
                resp.setTextoGerado(rset.getString("texto_gerado"));
                resp.setProducaoId(rset.getInt("producao_id"));

                respostaIa.add(resp);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }
        return respostaIa;
    }
}