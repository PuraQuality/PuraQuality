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

    public boolean save(Empresa empresa){

        //Comando sql
        String sql = "INSERT INTO empresa (nome, setor, cnpj, email, senha, plano_id) VALUES(?, ?, ?, ?, ?, ?)";

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
            pstm.setString(3,empresa.getEmail());
            pstm.setString(3,empresa.getSenha());
            pstm.setInt(3,empresa.getPlanoId());


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

    public List<Empresa> selectEmpresa(int empresaId){
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

            pstm.setInt(1,empresaId);

            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando usuario para ser armazenado na lista
                Empresa usuario1 = new Empresa();

                //Instanciando
                usuario1.setId(rset.getInt("id"));
                usuario1.setNome(rset.getString("email"));
                usuario1.setSenha(rset.getString("senha"));
                usuario1.setSetor(rset.getString("setor"));
                usuario1.setCnpj(rset.getString("cnpj"));
                usuario1.setEmail(rset.getString("email"));
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

    public List<Empresa> selectFiltro(String coluna, String filtro) throws SQLException {
        List<Empresa> usuarios = new ArrayList<>();

        //Comando sql
        String sql = "SELECT * FROM empresa where %s LIKE ?".formatted(coluna);

        //atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Conectando e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1,filtro);

            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando usuario para ser armazenado na lista
                Empresa usuario1 = new Empresa();

                //Instanciando
                usuario1.setId(rset.getInt("id"));
                usuario1.setNome(rset.getString("email"));
                usuario1.setSenha(rset.getString("senha"));
                usuario1.setSetor(rset.getString("setor"));
                usuario1.setCnpj(rset.getString("cnpj"));
                usuario1.setEmail(rset.getString("email"));
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

    public List<Empresa> selectFiltro(int empresaid, boolean filtro) throws SQLException {
        //Conectando e passando o comando sql
        List<Empresa> usuarios = new ArrayList<>();

        //Comando sql
        String sql = "SELECT * FROM empresa where id = ? and permissao = ?";

        //atribuindo valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Conectando e passando o comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1,empresaid);
            pstm.setBoolean(2,filtro);

            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while (rset.next()){
                //Criando usuario para ser armazenado na lista
                Empresa usuario1 = new Empresa();

                //Instanciando
                usuario1.setId(rset.getInt("id"));
                usuario1.setNome(rset.getString("email"));
                usuario1.setSenha(rset.getString("senha"));
                usuario1.setSetor(rset.getString("setor"));
                usuario1.setCnpj(rset.getString("cnpj"));
                usuario1.setEmail(rset.getString("email"));
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
        String sql = "UPDATE empresa SET nome = ?, setor = ?, email = ?, senha = ?, plano_id = ? WHERE id = ?";

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
            pstm.setInt(6,empresa.getId());


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