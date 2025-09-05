package com.example.puraquality;

//Importando classes para o JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Importando classe para manipular o env
import io.github.cdimascio.dotenv.Dotenv;

public class Conexao {
//    Declarando a conexão
    Connection conn;

//    Coletando informações do .env
    Dotenv dotenv = Dotenv.load();

//    Atribuindo informações do .env para as variáveis
    String db_url = dotenv.get("DB_URL");
    String db_usuario = dotenv.get("DB_USUARIO");
    String db_senha = dotenv.get("DB_SENHA");

//    Criando o Método para adquirir a conexão com o banco de dados
    public Connection conectar() {
        try {
            conn = DriverManager.getConnection(db_url,db_usuario,db_senha);
        }
        catch (SQLException sql){
            sql.printStackTrace();
        }finally {
            return conn;
        }
    }

//    Criando o métodopara desconectar o banco de dados
    public void desconectar() {
        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException sql){
            sql.printStackTrace();
        }
    }
}