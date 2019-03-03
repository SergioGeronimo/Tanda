/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanda.DAO;

import com.tanda.DB.Tanda;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Sergio Gerónimo
 */
public interface TandaDAO {
    
    public static Tanda createTanda(Tanda tanda, Connection conx){
        
        String query = "INSERT INTO `tanda`"
                + "(`ID_TANDA`, `ID_ADMIN`, `MONTO`, `ENTREGADA`) VALUES "
                + "(NULL, "
                + "\'" + tanda.getCURP() + "\',"
                + "\'" + tanda.getMonto() + "\',"
                + "NULL);";
        
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedKeys.first();
            
            tanda.setIdTanda(generatedKeys.getInt(1));
            stmt.close();
            
        }catch(SQLException sqlEx){
            System.out.println("ERROR " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch(NullPointerException nullEx){
            System.out.println("ERROR: NullPointerException on TandaDAO by createTanda");
            System.out.println(nullEx.getMessage());
        }
        
        return getTanda(tanda.getIdTanda(), conx);
    }
    
    public static boolean deleteTanda(int id, Connection conx){
        
        String query = "DELETE FROM `tanda` WHERE `tanda`.`ID_TANDA` = \'" + id + "\'";
        
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            
        }catch(SQLException sqlEx){
            System.out.println("ERROR " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch(NullPointerException nullEx){
            
            System.out.println("ERROR: NullPointerException on TandaDAO by deleteTanda");
            System.out.println(nullEx.getMessage());
            
        }
        
        return (getTanda(id, conx) == null);
    }
    
    public static Tanda updateTanda(int original, Tanda updated, Connection conx){
        
        String query = "UPDATE `tanda` SET "
                + "`ID_TANDA`=\'" + updated.getIdTanda()+ "\', "
                + "`ID_ADMIN`=\'" + updated.getCURP() + "\', "
                + "`MONTO`=\'" + updated.getMonto() + "\', "
                + "`ENTREGADA`=\'" + updated.isEntregadaSQL() + "\'"
                + "WHERE `tanda`.`ID_TANDA` = \'" + original + "\' ";
        
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            
        }catch(SQLException sqlEx){
            System.out.println("ERROR " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch(NullPointerException nullEx){
            
            System.out.println("ERROR: NullPointerException on TandaDAO by updateTanda");
            System.out.println(nullEx.getMessage());
            
        }
        
        return getTanda(updated.getIdTanda(), conx);
    }
    
    public static Tanda getTanda(int id, Connection conx){
        Tanda tanda = null;
        
        String query = "SELECT * FROM `tanda` WHERE `ID_TANDA` = " + id;
        
        try{
            Statement stmt = conx.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            
            tanda = new Tanda(
                                result.getInt("ID_TANDA"),
                                result.getString("ID_ADMIN"),
                                result.getLong("MONTO"),
                                result.getBoolean("ENTREGADA")
                    );
            stmt.close();
            
        }catch (SQLException sqlEx) {
            System.out.println("SELECT ERROR SQL: " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch (NullPointerException nullEx){
            System.out.println("ERROR: tanda inexistente, id inválido o conexión nula\n" + nullEx.getMessage());
        }
        
        return tanda;
    }
    
    public static Vector<Tanda> getAllTanda(String curp, Connection conx){
        Vector<Tanda> allTandas = new Vector<Tanda>();
        
        String query = "SELECT * FROM `tanda` WHERE `ID_ADMIN` = \'" + curp + "\'";
        
        try{
            Statement stmt = conx.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            while(result.next()){
                Tanda tanda = new Tanda (
                                            result.getInt("ID_TANDA"),
                                            result.getString("ID_ADMIN"),
                                            result.getLong("MONTO"),
                                            result.getBoolean("ENTREGADA")
                                         );
                allTandas.add(tanda);
            }
            stmt.close();
            
        }catch (SQLException sqlEx) {
            System.out.println("SELECT ERROR SQL: " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch (NullPointerException nullEx){
            System.out.println("ERROR: tandas inexistente, id inválido o conexión nula:\n" + nullEx.getMessage());
            System.out.println(nullEx.getCause());
        }
        
        return allTandas;
    }
    
}
