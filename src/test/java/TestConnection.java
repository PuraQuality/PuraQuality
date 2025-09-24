import com.repository.ConnectionFactory;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {

        Connection conn = null;

        try{
            conn = ConnectionFactory.createConnection();

            if (conn != null){
                System.out.println("Conexão aberta");
                conn.close();
            } else{
                System.out.println("Conexão esta fechada");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}