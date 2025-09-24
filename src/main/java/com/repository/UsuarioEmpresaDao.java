package com.repository;

//package
import com.conexao.ConnectionFactory;
import com.model.UsuarioEmpresa;

//sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//pacote util
import java.util.ArrayList;
import java.util.List;

public class UsuarioEmpresaDao{

    public void save(UsuarioEmpresa usuarioEmpresa){

        //Comando sql
        String sql = "INSERT INTO usuario_empresa (usuario_id, empresa_id) VALUES(?, ?)";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Conexão e passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando
            pstm.setInt(1, usuarioEmpresa.getUsuarioId());
            pstm.setInt(2, usuarioEmpresa.getEmpresaId());

            //Executando
            pstm.execute();
            System.out.println("Relacionamento salvo com sucesso!");

        }catch (Exception e){
            //Printando erros
            e.printStackTrace();
        }finally {
            //Fechando conexão e métodos
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public List<UsuarioEmpresa> select(){
        //Criando uma lista de usuario_empresa
        List<UsuarioEmpresa> lista = new ArrayList<UsuarioEmpresa>();

        //Comando sql
        String sql = "SELECT * FROM usuario_empresa";

        //atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Conectando e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando objeto para ser armazenado na lista
                UsuarioEmpresa ue = new UsuarioEmpresa();

                //Instanciando
                ue.setUsuarioId(rset.getInt("usuario_id"));
                ue.setEmpresaId(rset.getInt("empresa_id"));

                //add na lista
                lista.add(ue);
            }

        }catch (Exception e){
            //Printando erros
            e.printStackTrace();
        }finally {
            //Fechando conexão e métodos
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }
        return lista;
    }

    public void update(UsuarioEmpresa usuarioEmpresa, int novoUsuarioId, int novaEmpresaId){

        //String sql
        String sql = "UPDATE usuario_empresa SET usuario_id = ?, empresa_id = ? WHERE usuario_id = ? AND empresa_id = ?";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //faz a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //instanciando o pstm
            pstm.setInt(1, novoUsuarioId);
            pstm.setInt(2, novaEmpresaId);
            pstm.setInt(3, usuarioEmpresa.getUsuarioId());
            pstm.setInt(4, usuarioEmpresa.getEmpresaId());

            //executando
            pstm.execute();
            System.out.println("Relacionamento atualizado com sucesso!");

        }catch (Exception e){
            //Printando erros
            e.printStackTrace();
        }finally {
            //Fechando conexão e métodos
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
        }
    }

    public void deleteById(int usuarioId, int empresaId){

        //comando sql
        String sql = "DELETE FROM usuario_empresa WHERE usuario_id = ? AND empresa_id = ?";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //faz a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando
            pstm.setInt(1, usuarioId);
            pstm.setInt(2, empresaId);

            //executando
            pstm.execute();
            System.out.println("Relacionamento deletado com sucesso!");

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