package com.repository;

//Importação do meu pacote
import com.model.Plano;

//Importações de sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//importações do pacote util
import java.util.ArrayList;
import java.util.List;


public class PlanoDao extends Dao <Plano>{

    //Create
    public void save(Plano plano){

        //Comando SQL
        String sql = "INSERT INTO plano (id, nome, preco, limite_de_funcionalidades) VALUES(?, ?, ?, ?)";

        //atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Fazendo a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //instanciando o pstm
            pstm.setInt(1, plano.getId());
            pstm.setString(2, plano.getNome());
            pstm.setDouble(3, plano.getPreco());
            pstm.setInt(4, plano.getLimiteFuncionalidades());

            //Executando o comando
            pstm.execute();
            System.out.println("Salvo com sucesso!");

        }catch (Exception e){
            //Printando erros
            e.printStackTrace();
        }finally {
            //Fechando conexão e métodos
            ConnectionFactory.fecharConnection(conn);
            PlanoDao.fecharPstm(pstm);
        }
    }


    //Read
    public List<Plano> select(){
        //Cria uma lista dos planos
        List<Plano> planos = new ArrayList<Plano>();

        //Comando sql
        String sql = "SELECT * FROM plano";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            //Fazendo a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Percorre as linhas do comando sql
            while(rset.next()){
                //Criando objeto plano
                Plano plano = new Plano();

                //Instanciando
                plano.setId(rset.getInt("id"));
                plano.setNome(rset.getString("nome"));
                plano.setPreco(rset.getDouble("preco"));
                plano.setLimiteFuncionalidades(rset.getInt("limite_de_funcionalidades"));

                //Salvando na lista
                planos.add(plano);
            }
        }catch (Exception e){
            //printando erros
            e.printStackTrace();
        }finally {
            //Fechando conexão e métodos
            ConnectionFactory.fecharConnection(conn);
            Dao.fecharPstm(pstm);
            Dao.fecharRset(rset);
        }
        return planos;
    }


    //Update
    public void update(Plano plano){

        //Comando sql
        String sql = "UPDATE plano SET nome = ?, preco = ?, limite_de_funcionalidades = ? WHERE id = ? ";

        //Atribuição de null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Faz a conexão e a passagem do comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Instanciando o pstm
            pstm.setString(1,plano.getNome());
            pstm.setDouble(2,plano.getPreco());
            pstm.setInt(3,plano.getLimiteFuncionalidades());
            pstm.setInt(4,plano.getId());

            //Executando query
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


    //Delete
    public void deleteById(int id){

        //Comando SQL
        String sql = "DELETE FROM plano WHERE id = ?";

        //Atribuição dos valores null
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Conectando e passando comando sql
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            //Passando o id e executando
            pstm.setInt(1,id);

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
