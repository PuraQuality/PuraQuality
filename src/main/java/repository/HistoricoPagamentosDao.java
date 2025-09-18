package repository;

import model.HistoricoPagamentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoricoPagamentosDao extends Dao<HistoricoPagamentos>{

    public void save(HistoricoPagamentos historicoPagamento) {

//        Comando sql
        String sql = "INSERT INTO historico_pagamentos (valor_pago, forma_pagamento, usuario_id, data_pagamento) VALUES (?,?,?,?)";

//        Atribuindo valores null para o conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnection();

//            Criamos uma PreparedStatement, para executar uma query
            pstm = conn.prepareStatement(sql);

//            Adicionar valores que são esperados pela query
            pstm.setDouble(1, historicoPagamento.getValorPago());
            pstm.setString(2, historicoPagamento.getFormaPagamento());
            pstm.setInt(3, historicoPagamento.getUsuarioId());
            pstm.setTimestamp(4, historicoPagamento.getDataPagamento());

//            Executar a query
            pstm.executeUpdate();
            System.out.println("Salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void update(HistoricoPagamentos historicoPagamento) {
//        Comando sql
        String sql = "UPDATE historico_pagamentos SET valor_pago = ?, forma_pagamento = ?, usuario_id = ?, data_pagamento = ? WHERE id = ?";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Criando conexão e preparando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Instanciando os valores no pstm
            pstm.setDouble(1, historicoPagamento.getValorPago());
            pstm.setString(2, historicoPagamento.getFormaPagamento());
            pstm.setInt(3, historicoPagamento.getUsuarioId());
            pstm.setTimestamp(4, historicoPagamento.getDataPagamento());
            pstm.setInt(5, historicoPagamento.getId());

//            Executando o comando sql
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

    public void deleteById(int id) {

//        Comando sql
        String sql = "DELETE FROM historico_pagamentos WHERE id = ?";

//        Atribuindo null para conn e pstm
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
//            Fazendo a conexao e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

//            Passando o id que será deletado
            pstm.setInt(1, id);

//            Executando
            pstm.executeUpdate();
            System.out.println("Deletado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public List<HistoricoPagamentos> select() {

//        Comando sql
        String sql = "SELECT * FROM historico_pagamentos";

//        Atribuindo valores null para o conn, pstm e rset
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

//        Criando lista para armazenar resultados
        List<HistoricoPagamentos> lista = new ArrayList<>();

        try {
//            Criando uma conexão com o banco de dados
            conn = ConnectionFactory.createConnection();

//            Criamos uma PreparedStatement, para executar uma query
            pstm = conn.prepareStatement(sql);

//            Criando um ResultSet para armazenar a query
            rset = pstm.executeQuery();

            while (rset.next()) {
//                Criando objeto para ser armazenado na lista
                HistoricoPagamentos historicoPagamento = new HistoricoPagamentos();

//                Instanciando os valores
                historicoPagamento.setId(rset.getInt("id_historico"));
                historicoPagamento.setValorPago(rset.getDouble("valor_pago"));
                historicoPagamento.setFormaPagamento(rset.getString("forma_pagamento"));
                historicoPagamento.setUsuarioId(rset.getInt("usuario_id"));
                historicoPagamento.setDataPagamento(rset.getTimestamp("data_pagamento"));

//                Adicionando na lista
                lista.add(historicoPagamento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            Fechando conexoes
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }
        return lista;
    }
}