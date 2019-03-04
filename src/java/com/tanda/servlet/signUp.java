/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanda.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanda.DAO.JConnector;
import com.tanda.DAO.PersonaDAO;
import com.tanda.DAO.UsuarioDAO;
import com.tanda.DB.Persona;
import com.tanda.DB.Usuario;
import java.sql.Connection;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio Gerónimo
 */
public class signUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            
            Persona person = new Persona(
                    request.getParameter("CURP"),
                    request.getParameter("NOMBRE"),
                    request.getParameter("APELLIDO"),
                    request.getParameter("DIRECCION"),
                    
                    Long.valueOf(request.getParameter("TELEFONO"))
            );
            
            Usuario user = new Usuario(
                    0,
                    request.getParameter("CURP"),
                    request.getParameter("PASSWORD"),
                    Boolean.valueOf(request.getParameter("ADMIN"))
            );
            
            Connection conx = JConnector.conectDB();
            
            person = PersonaDAO.createPersona(person, conx);
            user = UsuarioDAO.createUsuario(user, conx);
            
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", user);
            
            request.getRequestDispatcher("/view/user").forward(request, response);
            
        }catch(NullPointerException nullEx){
            
            System.out.println(nullEx.getMessage());
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
