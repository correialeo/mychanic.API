package com.mychanic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    Connection connection;

    public ConnectionFactory(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com:1521:ORCL",
                    "rm556203", "080505");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        try{
            if (connection == null){
                connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com:1521:ORCL",
                        "rm556203", "080505");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return connection;
    }

}
