package com.tanda.DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author Sergio M. Gerónimo González
 */

public interface JConnector {
    
    public static Connection conectDB() {
        try{
            System.out.println("Iniciando JDBC...");
            Class.forName("com.mysql.jdbc.Driver");
            
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tanda", info);
            
            
            return conn;
            
        }catch (ClassNotFoundException classErr){
             System.out.print(classErr.getMessage());
             
             
             return null;
        }catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
            
        }
                
    }
}

