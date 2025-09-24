package com.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class Dao <T> {

    //Create
    public abstract void save(T entidade);

    //Read
    public abstract List<T> select();

    //Update
    public abstract void update(T entidade);

    //Delete
    public abstract void deleteById(int id);


    //Fechamento dos métodos
    public static void fecharPstm(PreparedStatement pstm){  //Fechar o PreparedStatment

        try {
            if (pstm != null && !pstm.isClosed()) {
                pstm.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fecharRset(ResultSet rset){
        try{
            if (rset != null && !rset.isClosed()){
                rset.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}