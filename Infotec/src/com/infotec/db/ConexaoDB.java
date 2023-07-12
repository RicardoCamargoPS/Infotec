package com.infotec.db;

import java.sql.*;

/**
 *
 * @author ricardo
 */
public class ConexaoDB {
    
    public static Connection conector(){
        Connection conexao = null;
        
        String driver = "com.mysql.cj.jdbc.Driver";
        
        String url = "jdbc:mysql://localhost:3306/db_assiinfo";
        String user = "root";
        String password = "admin";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
 
            return conexao;  
            
        } catch (Exception e) {
            System.out.println(e);
            return null;            
        }
        
    }
    
}
