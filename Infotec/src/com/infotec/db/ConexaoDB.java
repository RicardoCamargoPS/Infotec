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
        
        String url = "jdbc:mysql://localhost:3306/dbinfotec";
        String user = "root";
        String password = "vnqu2412";
        
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
