/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanda.DAO;

import com.tanda.DB.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public interface UsuarioDAO {
    static Usuario createUsuario(Usuario user, Connection conx){
        
        String query = "INSERT INTO `usuario`"
                + "(`ID_USUARIO`, `ID_PERSONA`, `PASSWORD`) VALUES"
                + "( NULL,"
                + "\'" + user.getCurp() + "\',"
                + "\'" + user.getPassword() + "\');";
        
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            
            
            generatedKeys.first();           
            
            user.setId(generatedKeys.getInt(1));
            
            
        }catch(SQLException sqlEx){
            System.out.println("ERROR " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        }catch(NullPointerException nullEx){
            System.out.println("ERROR: NullPointerException on UsuarioDAO by createUsuario");
            System.out.println(nullEx.getMessage());
        }
        
        return getUsuario(user.getId(), conx);
    }
    
    static void deleteUsuario(int id, Connection conx){
        
        String query = "DELETE FROM `usuario` WHERE `usuario`.`ID_USUARIO` = \'"+id+"\'";
        
            try{
                Statement stmt = conx.createStatement();
                stmt.executeUpdate(query);
                
            }catch(SQLException sqlEx){
                System.out.println("ERROR " + sqlEx.getErrorCode());
                System.out.println(sqlEx.getMessage());
                
            }catch(NullPointerException nullEx){
                System.out.println("ERROR: NullPointerException on UsuarioDAO by deleteUsuario");
                System.out.println(nullEx.getMessage());
            }
    }
    
    static Usuario updateUsuario(int original, Usuario updated, Connection conx){
        String query = "UPDATE `usuario` SET "
                + "`ID_USUARIO` = \'" + updated.getId() + "\',"
                + "`ID_PERSONA` = \'" + updated.getCurp() + "\',"
                + "`PASSWORD` = \'" + updated.getPassword() + "\'"
                + "WHERE `usuario`.`ID_USUARIO` = \'" + original + "\'";
        
        try{
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException sqlEx){
            System.out.println("ERROR " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());

        }catch(NullPointerException nullEx){
            System.out.println("ERROR: NullPointerException on UsuarioDAO by updateUsuario");
            System.out.println(nullEx.getMessage());
        }
        
        return getUsuario(updated.getId(), conx);
        
    }
    
    static Usuario getUsuario(int id, Connection conx){
        Usuario user = null;
        String query = "SELECT * FROM `usuario` WHERE `ID_USUARIO` = " + id;
        
        try{
            Statement stmt = conx.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            user = new Usuario(
                                result.getInt("ID_USUARIO"),
                                result.getString("ID_PERSONA"),
                                result.getString("PASSWORD")
                                );
            
        } catch (SQLException sqlEx) {
            System.out.println("ERROR " + sqlEx.getErrorCode());
            System.out.println(sqlEx.getMessage());
            
        } catch (NullPointerException nullEx){
            System.out.println("ERROR: persona inexistente, id inválido o conexión nula\n" + nullEx.getMessage());
        }
        
        return user;
    }
}
