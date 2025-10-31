package com.dao;

//package
import com.conexao.ConnectionFactory;
import com.model.Funcionario;

//sql
import java.sql.*;

//pacote util
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao extends Dao<Funcionario> {

//    Método para salvar funcionário no banco de dados
    public boolean save(Funcionario usuario){

        //Comando sql
        String sql = "INSERT INTO funcionario (nome, sobrenome, email, senha, empresa_id, permissao, telefone) VALUES(?, ?, ?, ?, ?, ?, ?)";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Conexão e passagemm do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando
            pstm.setString(1,usuario.getNome());
            pstm.setString(2,usuario.getSobrenome());
            pstm.setString(3,usuario.getEmail());
            pstm.setString(4,usuario.getSenha());
            pstm.setInt(5,usuario.getEmpresaId());
            pstm.setBoolean(6,usuario.isPrioridade());
            pstm.setString(7,usuario.getTelefone());

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

//    Método para selecionar o funcionário baseado em sua empresa no banco de dados
    public List<Funcionario> selectEmpresa(int empresaId){
        //Criando uma lista de usuarios
        List<Funcionario> usuarios = new ArrayList<>();

        //Comando sql
        String sql = "SELECT * FROM funcionario where empresa_id = ?";

        //atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Conectando e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1,empresaId);

            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando usuario para ser armazenado na lista
                Funcionario usuario1 = new Funcionario();

                //Instanciando
                usuario1.setId(rset.getInt("id"));
                usuario1.setNome(rset.getString("nome"));
                usuario1.setSobrenome(rset.getString("sobrenome"));
                usuario1.setTelefone(rset.getString("telefone"));
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

//    Método para selecionar funcionário de acordo com o filtro no banco de dados
    public List<Funcionario> selectFiltro(int empresaid,String coluna, String filtro) throws SQLException {
        //Criando uma lista de usuarios
        List<Funcionario> usuarios = new ArrayList<>();

        //Comando sql
        String sql = "SELECT * FROM funcionario where upper(%s) LIKE upper(?) and empresa_id = ?".formatted(coluna) ;

        //atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        if(coluna.equals("plano")){
            sql = "SELECT * FROM upper(plano) where nome LIKE upper(?)";
        }

        try{
            //Conectando e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,"%" + filtro + "%");
            pstm.setInt(2,empresaid);

            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando usuario para ser armazenado na lista
                Funcionario usuario1 = new Funcionario();

                //Instanciando
                usuario1.setId(rset.getInt("id"));
                usuario1.setNome(rset.getString("nome"));
                usuario1.setSobrenome(rset.getString("sobrenome"));
                usuario1.setTelefone(rset.getString("telefone"));
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

//    Método para selecionar funcionário com a permissão desejada no banco de dados
    public List<Funcionario> selectFiltro(int empresaid, boolean filtro) throws SQLException {
        //Criando uma lista de usuarios
        List<Funcionario> usuarios = new ArrayList<>();

        //Comando sql
        String sql = "SELECT * FROM funcionario where permissao = ? and empresa_id = ?";

        //atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Conectando e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setBoolean(1,filtro);
            pstm.setInt(2,empresaid);

            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando usuario para ser armazenado na lista
                Funcionario usuario1 = new Funcionario();

                //Instanciando
                usuario1.setId(rset.getInt("id"));
                usuario1.setNome(rset.getString("nome"));
                usuario1.setSobrenome(rset.getString("sobrenome"));
                usuario1.setTelefone(rset.getString("telefone"));
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

//    Método para selecionar todos os funcionário no banco de dados
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
                usuario1.setNome(rset.getString("nome"));
                usuario1.setSobrenome(rset.getString("sobrenome"));
                usuario1.setTelefone(rset.getString("telefone"));
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

//    Método para atualizar o funcionário no banco de dados
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

//    Método para deletar o funcionário do banco de dados
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