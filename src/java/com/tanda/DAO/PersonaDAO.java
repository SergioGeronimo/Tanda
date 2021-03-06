/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanda.DAO;

import com.tanda.DB.Persona;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sergio M. Gerónimo González
 */

public interface PersonaDAO {
    
    
    
    public static Persona createPersona(Persona persona, Connection conx){
        
        
        if(conx != null){
            
            String query = "INSERT INTO `persona`"
                    + "(`CURP`, `NOMBRE`, `APELLIDO`, `DIRECCION`, `TELEFONO`) VALUES"
                    + "(\'" + persona.getCurp() + "\',"
                    + "\'" + persona.getNombre() + "\',"
                    + "\'" + persona.getApellido() + "\',"
                    + "\'" + persona.getDireccion() + "\',"
                    + "\'" + persona.getTelefono() + "\');";
            try{
                Statement stmt = conx.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                
            }catch(SQLException sqlEx){
                System.out.println("ERROR " + sqlEx.getErrorCode());
                System.out.println(sqlEx.getMessage());
                
            }
        }
        
        return getPersona(persona.getCurp(), conx);
    }
    
    public static boolean deletePersona(String curp, Connection conx){
        if(conx != null){
            
            String query = "DELETE FROM `persona` WHERE `persona`.`CURP` = \'"+curp+"\'";
            try{
                Statement stmt = conx.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                
            }catch(SQLException sqlEx){
                System.out.println("ERROR " + sqlEx.getErrorCode());
                System.out.println(sqlEx.getMessage());
            }
            
        }
        return (getPersona(curp, conx) == null);
    }
    
    public static Persona updatePersona(String originalCurp, Persona update, Connection conx){
        
        String query = "UPDATE `persona` SET"
                + "`CURP` = \'" + update.getCurp() + "\',"
                + "`NOMBRE` = \'" + update.getNombre() + "\',"
                + "`APELLIDO` = \'" + update.getApellido() + "\',"
                + "`DIRECCION` = \'" + update.getDireccion() + "\',"
                + "`TELEFONO` = \'" + update.getTelefono() + "\'"
                + "WHERE `persona`.`CURP` = \'" + originalCurp + "\'";
        
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            
        }catch(SQLException sqlEx){
            System.out.println("ERROR " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
        }
        
        return getPersona(update.getCurp(), conx);
    }
    
    public static Persona getPersona(String curp, Connection conx){
        
        Persona persona = null;
        
        if( conx != null){
            String query = "SELECT * FROM `persona` WHERE `CURP`='"+ curp +"'";
            
            try {
                Statement stmt = conx.createStatement();
                ResultSet resultado = stmt.executeQuery(query);
                resultado.next();
                
                persona = new Persona(  resultado.getString("CURP"),
                                        resultado.getString("NOMBRE"),
                                        resultado.getString("APELLIDO"),
                                        resultado.getString("DIRECCION"),
                                        resultado.getLong("TELEFONO"));
                stmt.close();
                
                return persona;
                
            } catch (SQLException ex) {
                System.out.println("getPersona - ERROR: "+ ex.getErrorCode());
                System.out.println(ex.getMessage());
                return null;
            }catch (NullPointerException nullex){
                System.out.println(nullex.getMessage() + " error en nullpointer");
                return null;
            }
        }
        else{
            return null;
        }
        
    }
    
}
