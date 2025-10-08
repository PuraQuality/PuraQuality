package com.repository;

//package
import com.conexao.ConnectionFactory;
import com.model.Funcionario;

//sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//pacote util
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao extends Dao<Funcionario> {
    public boolean save(Funcionario usuario){

        //Comando sql
        String sql = "INSERT INTO funcionario (email, senha, empresa_id, permissao) VALUES(?, ?, ?, ?)";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Conexão e passagemm do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando
            pstm.setString(1,usuario.getEmail());
            pstm.setString(2,usuario.getSenha());
            pstm.setInt(3,usuario.getEmpresaId());
            pstm.setBoolean(4,usuario.isPrioridade());

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

    public List<Funcionario> select(){
        //Criando uma lista de usuarios
        List<Funcionario> usuarios = new ArrayList<Funcionario>();

        //Comando sql
        String sql = "SELECT * FROM funcionario";

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
                //Criando usuario para ser armazenado na lista
                Funcionario usuario1 = new Funcionario();

                //Instanciando
                usuario1.setId(rset.getInt("id"));
                usuario1.setEmail(rset.getString("email"));
                usuario1.setSenha(rset.getString("senha"));
                usuario1.setEmpresaId(rset.getInt("empresa_id"));
                usuario1.setPrioridade(rset.getBoolean("permissao"));

                //add na lista
                usuarios.add(usuario1);
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
        return usuarios;
    }

    public void update(Funcionario funcionario){

        //String sql
        String sql = "UPDATE funcionario SET email = ?, senha = ?, permissao = ? WHERE id = ?";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //faz a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //instanciando o pstm
            pstm.setString(1, funcionario.getEmail());
            pstm.setString(2, funcionario.getSenha());
            pstm.setBoolean(3,funcionario.isPrioridade());
            pstm.setInt(4,funcionario.getId());

            System.out.println(funcionario);
            //executando
            pstm.executeUpdate();
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
        String sql = "DELETE FROM funcionario WHERE id = ?";

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