package com.github.jonasdsg.app.infraestruture;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private Connection conn;
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/database_teste","root","mysql");
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            return null;
        }
    }
}
