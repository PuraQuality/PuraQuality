package com.repository;

//package
import com.conexao.ConnectionFactory;
import com.model.Empresa;

//sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//pacote util
import java.util.ArrayList;
import java.util.List;

public class EmpresaDao extends Dao<Empresa> {

    public boolean save(Empresa empresa){

        //Comando sql
        String sql = "INSERT INTO empresa (nome, setor, cnpj) VALUES(?, ?, ?)";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Conexão e passagemm do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando
            pstm.setString(1,empresa.getNome());
            pstm.setString(2,empresa.getSetor());
            pstm.setString(3,empresa.getCnpj());

            //Executando
            System.out.println("Salvo com sucesso!");
            return pstm.executeUpdate() > 0;

        }catch (Exception e){
            //Printando erros
            e.printStackTrace();
            return false;
        }finally {
            //Fechando conexão e métodos
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public List<Empresa> select(){

        //Criando a lista
        List<Empresa> empresas = new ArrayList<Empresa>();

        //Comando sql
        String sql = "SELECT * FROM empresa";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Fazendo a conexão e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Cria o objeto para ser armazenado na lista
                Empresa empresa = new Empresa();

                //Instanciando
                empresa.setId(rset.getInt("id"));
                empresa.setNome(rset.getString("nome"));
                empresa.setSetor(rset.getString("setor"));
                empresa.setCnpj(rset.getString("cnpj"));

                //Armazenando dentro da lista
                empresas.add(empresa);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //Fechando conexões
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }
        return empresas;
    }

    public void update(Empresa empresa){

        //String sql
        String sql = "UPDATE empresa SET nome = ?, setor = ?, cnpj = ? WHERE id = ?";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //faz a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //instanciando o pstm
            pstm.setString(1, empresa.getNome());
            pstm.setString(2, empresa.getSetor());
            pstm.setString(3,empresa.getCnpj());
            pstm.setInt(4,empresa.getId());

            //executando
            pstm.execute();
            System.out.println("Salvo com sucesso!");

        }catch (Exception e){
            //Printando erros
            e.printStackTrace();
        }finally {
            //Fechando conexão e métodos
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void deleteById(int id){

        //comando sql
        String sql = "DELETE FROM empresa WHERE id = ?";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //faz a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando
            pstm.setInt(1,id);

            //executando
            pstm.execute();
            System.out.println("Deletado com sucesso!");

        }catch (Exception e){
            //Printando erros
            e.printStackTrace();
        }finally {
            //Fechando conexão e métodos
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }

    }
}