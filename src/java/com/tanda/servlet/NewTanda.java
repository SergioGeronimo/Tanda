/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tanda.servlet;

import com.tanda.DAO.JConnector;
import com.tanda.DAO.PagoDAO;
import com.tanda.DAO.TandaDAO;
import com.tanda.DB.Pago;
import com.tanda.DB.Tanda;
import com.tanda.DB.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jahaziel A. Sanchez Moreno
 */
public class NewTanda extends HttpServlet {

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
        
        int index = 0;
        Vector<Pago> pagos = new Vector<Pago>();
        
        HttpSession session = request.getSession(false);
        Tanda tanda = null;
        Connection conx = JConnector.conectDB();
        
        try{
            Usuario usuario = (Usuario)session.getAttribute("usuario");
            tanda = new Tanda(
                    0,
                    usuario.getCurp(),
                    Long.valueOf(request.getParameter("MONTO")),
                    false);
            
            tanda = TandaDAO.createTanda(tanda, conx);
            
            String check = request.getParameter("CURP"+index);
            while(check != null){
                System.out.println("On CURP"+index);
                Pago pago = new Pago(
                            0,
                            request.getParameter("CURP"+index),
                            Date.valueOf(request.getParameter("DATE"+index)),
                            tanda.getIdTanda(),
                            false,
                            false);
                
                PagoDAO.createPago(pago, conx);
                pagos.add(pago);
                index++;
                check = request.getParameter("CURP"+index);
            }
            
            request.getRequestDispatcher("/view/tandas").forward(request, response);
        }catch(NullPointerException | NumberFormatException nullEx){
            request.getRequestDispatcher("/new/tanda.jsp").forward(request, response);
            nullEx.printStackTrace();
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
