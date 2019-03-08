/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanda.DAO;

import com.tanda.DB.Pago;
import com.tanda.DB.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Sergio Gerónimo
 */
public interface PagoDAO {
    
    public static Pago createPago(Pago pago, Connection conx){
        
        String query = "INSERT INTO `pago`"
                + "(`ID_PAGO`, `ID_PERSONA`, `FECHA`, `ID_TANDA`, `PAGADO`, `ACEPTADO`) VALUES "
                + "(NULL, "
                + "\'" + pago.getCURP() +  "\', "
                + "\'" + pago.getFecha().toString() + "\', "
                + "" + pago.getIdTanda() + ", "
                + "0,"
                + "0);";
        
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedKeys.first();
            
            pago.setPago(generatedKeys.getInt(1));
            
            stmt.close();
            
        }catch(SQLException sqlEx){
            System.out.println("createPago ERROR: " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch(NullPointerException nullEx){
            System.out.println("createPago ERROR: NullPointerException");
            System.out.println(nullEx.getMessage());
        }
        
        return getPago(pago.getId(), conx);
    }
    
    public static boolean deletePago(int id, Connection conx){
        
        String query = "DELETE FROM `pago` WHERE `pago`.`ID_PAGO` = \'" + id + "\'";
        
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            
        }catch(SQLException sqlEx){
            System.out.println("deletePago ERROR: " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch(NullPointerException nullEx){
            System.out.println("deletePago ERROR: NullPointerException");
            System.out.println(nullEx.getMessage());
        }
        
        
        return (getPago(id, conx) == null);
    }
    
    public static Pago updatePago(int original, Pago updated, Connection conx){
        
        String query = "UPDATE `pago` SET "
                + "`ID_PAGO` = \'" + updated.getId() + "\', "
                + "`ID_PERSONA` = \'" + updated.getCURP() + "\', "
                + "`FECHA` = \'" + updated.getFecha().toString() +"\', "
                + "`ID_TANDA` = \'" + updated.getIdTanda() + "\', "
                + "`PAGADO` = \'" + updated.isPagadoSQL() + "\', "
                + "`ACEPTADO` = \'" + updated.isAceptado() + "\' "
                + "WHERE `pago`.`ID_PAGO` = \'" + original + "\'";
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            
        }catch(SQLException sqlEx){
            System.out.println("updatePago ERROR: " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch(NullPointerException nullEx){
            System.out.println("updatePago ERROR: NullPointerException");
            System.out.println(nullEx.getMessage());
        }
        
        return getPago(updated.getId(), conx);
    }
    
    public static Pago getPago(int id, Connection conx){
        Pago pago = null;
        
        String query = "SELECT * FROM `pago` WHERE `ID_PAGO` = \'" + id + "\'";
        
        try{
            Statement stmt = conx.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            result.next();
            
            pago = new Pago(
                            result.getInt("ID_PAGO"),
                            result.getString("ID_PERSONA"),
                            result.getDate("FECHA"),
                            result.getInt("ID_TANDA"),
                            result.getBoolean("PAGADO"),
                            result.getBoolean("ACEPTADO")
                            );
            stmt.close();
        }catch (SQLException sqlEx) {
            
            System.out.println("SELECT ERROR SQL: " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch (NullPointerException nullEx){
            
            System.out.println("ERROR: pago inexistentes, id inválido o conexión nula:\n" + nullEx.getMessage());
            System.out.println(nullEx.getCause());
        }
        
        return pago;
    }
    
    public static Vector<Pago> getAllPagos(int id, Connection conx){
        
        Vector<Pago> allPagos = new Vector<Pago>();
        
        String query = "SELECT * FROM `pago` WHERE `ID_TANDA` = \'" + id + "\' ORDER BY `FECHA` ASC;";
        
        try{
            Statement stmt = conx.createStatement();
            ResultSet result = stmt.executeQuery(query);
            
            while(result.next()){
            
                Pago pago = new Pago(
                                result.getInt("ID_PAGO"),
                                result.getString("ID_PERSONA"),
                                result.getDate("FECHA"),
                                result.getInt("ID_TANDA"),
                                result.getBoolean("PAGADO"),
                                result.getBoolean("ACEPTADO")
                                );
                allPagos.add(pago);
                
            }
            stmt.close();
        }catch (SQLException sqlEx) {
            
            System.out.println("SELECT ERROR SQL: " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch (NullPointerException nullEx){
            
            System.out.println("ERROR: pago inexistentes, id inválido o conexión nula:\n" + nullEx.getMessage());
            System.out.println(nullEx.getCause());
        }
        
        return allPagos;
    }
    
    public static Vector<Persona> getAllDeudores(Vector<Pago> allPagos, Connection conx){
        Vector<Persona> allDeudores = new Vector<Persona>();
        
        try{
            for (int i = 0; i < allPagos.size(); i++){
                allDeudores.add(PersonaDAO.getPersona(allPagos.elementAt(i).getCURP(), conx));
            }
        }catch(NullPointerException nullEx){
            nullEx.printStackTrace();
        }
        
        return allDeudores;
    }
    
}
