package com.dao;

//package
import com.conexao.ConnectionFactory;
import com.model.Empresa;
import com.model.Funcionario;

//sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//pacote util
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDao extends Dao<Empresa> {

//    Método para salvar empresa no banco de dados
    public boolean save(Empresa empresa){

        //Comando sql
        String sql = "INSERT INTO empresa (nome, setor, cnpj, email, senha, plano_id, telefone) VALUES(?, ?, ?, ?, ?, ?, ?)";

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
            pstm.setString(4,empresa.getEmail());
            pstm.setString(5,empresa.getSenha());
            pstm.setInt(6,empresa.getPlanoId());
            pstm.setString(7,empresa.getTelefone());


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

//    Método para selecionar uma empresa específica no banco de dados
    public List<Empresa> selectEmpresa(int id){
        //Criando uma lista de usuarios
        List<Empresa> usuarios = new ArrayList<>();

        //Comando sql
        String sql = "SELECT * FROM empresa where id = ?";

        //atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Conectando e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1,id);

            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando usuario para ser armazenado na lista
                Empresa empresas = new Empresa();

                //Instanciando
                empresas.setId(rset.getInt("id"));
                empresas.setNome(rset.getString("nome"));
                empresas.setSenha(rset.getString("senha"));
                empresas.setSetor(rset.getString("setor"));
                empresas.setCnpj(rset.getString("cnpj"));
                empresas.setEmail(rset.getString("email"));
                empresas.setPlanoId(rset.getInt("plano_id"));
                empresas.setTelefone(rset.getString("telefone"));
                empresas.setPlano((empresas.getPlanoId() == 10)?"Quality":(empresas.getPlanoId() == 11)?"FullQuality":"PuraQuality");

                //add na lista

                usuarios.add(empresas);
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

//    Método para selecionar a empresa com o filtro correspondente no banco de dados
    public List<Empresa> selectFiltro(String coluna, String filtro) throws SQLException {
        List<Empresa> usuarios = new ArrayList<>();

        //Comando sql
        String sql = "SELECT * FROM empresa where upper(%s) LIKE upper(?)".formatted(coluna);

        if(coluna.equals("plano")){
            sql = "SELECT * FROM upper(plano) where nome LIKE upper(?)";
        }
        else if(coluna.equals("id")){
            sql = "SELECT * FROM empresa where id = ?";
        }

        //atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Conectando e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1,"%" + filtro + "%");

            if(coluna.equals("id")){
                pstm.setString(1,filtro);
            }

            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando usuario para ser armazenado na lista
                Empresa empresas = new Empresa();

                //Instanciando
                empresas.setId(rset.getInt("id"));
                empresas.setNome(rset.getString("nome"));
                empresas.setSenha(rset.getString("senha"));
                empresas.setSetor(rset.getString("setor"));
                empresas.setCnpj(rset.getString("cnpj"));
                empresas.setEmail(rset.getString("email"));
                empresas.setPlanoId(rset.getInt("plano_id"));
                empresas.setTelefone(rset.getString("telefone"));
                empresas.setPlano((empresas.getPlanoId() == 10)?"Quality":(empresas.getPlanoId() == 11)?"FullQuality":"PuraQuality");

                //add na lista
                usuarios.add(empresas);
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

//    Método para selecionar todas as empresa no banco de dados
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
                empresa.setEmail(rset.getString("email"));
                empresa.setSenha(rset.getString("senha"));
                empresa.setPlanoId(rset.getInt("plano_id"));
                empresa.setTelefone(rset.getString("telefone"));
                empresa.setPlano((empresa.getPlanoId() == 10)?"Quality":(empresa.getPlanoId() == 11)?"FullQuality":"PuraQuality");


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

//    Método para atualizar empresa do banco de dados
    public void update(Empresa empresa){

        //String sql
        String sql = "UPDATE empresa SET nome = ?, setor = ?, email = ?, senha = ?, plano_id = ?, telefone = ? WHERE id = ?";

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
            pstm.setString(3, empresa.getEmail());
            pstm.setString(4, empresa.getSenha());
            pstm.setInt(5, empresa.getPlanoId());
            pstm.setString(6, empresa.getTelefone());
            pstm.setInt(7,empresa.getId());


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

//    Método para deletar a empresa no banco de dados
    public void deleteById(int id){
        //Comando sql
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