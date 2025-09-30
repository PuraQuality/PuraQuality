package com.repository;

//package
import com.conexao.ConnectionFactory;
import com.model.Usuario;

//sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//pacote util
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends Dao<Usuario> {
    public boolean save(Usuario usuario){

        //Comando sql
        String sql = "INSERT INTO usuario (email, senha, plano_id) VALUES(?, ?, ?)";

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
            pstm.setInt(3,usuario.getPlanoId());

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

    public List<Usuario> select(){
        //Criando uma lista de usuarios
        List<Usuario> usuarios = new ArrayList<Usuario>();

        //Comando sql
        String sql = "SELECT * FROM usuario";

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
                Usuario usuario1 = new Usuario();

                //Instanciando
                usuario1.setId(rset.getInt("id"));
                usuario1.setEmail(rset.getString("email"));
                usuario1.setSenha(rset.getString("senha"));
                usuario1.setPlanoId(rset.getInt("plano_id"));

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

    public void update(Usuario usuario){

        //String sql
        String sql = "UPDATE usuario SET email = ?, senha = ?, plano_id = ? WHERE id = ?";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //faz a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //instanciando o pstm
            pstm.setString(1, usuario.getEmail());
            pstm.setString(2, usuario.getSenha());
            pstm.setInt(3,usuario.getPlanoId());
            pstm.setInt(4,usuario.getId());

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
        String sql = "DELETE FROM usuario WHERE id = ?";

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