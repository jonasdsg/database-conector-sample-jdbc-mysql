package com.github.jonasdsg.app.domain.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.github.jonasdsg.app.infraestruture.Connector;

public class DatabaseService {
    private Connection conn;

    private DatabaseService(){
        this.conn = new Connector().getConnection();
    }

    public void insert(String nome){
        var sql = "INSERT INTO nomes(nome) VALUES (?)";
        try (var pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1,nome);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro: "+e.getMessage());
        }
    }

    public void list(){
        var sql = "SELECT * FROM nomes";
        
        try{
            var pstmt = this.conn.prepareStatement(sql);
            var result = pstmt.executeQuery();
            while(result.next()){
                System.out.println(result.getString("nome"));
            }
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }

    public static DatabaseService getService(){
        return new DatabaseService();
    }
}
