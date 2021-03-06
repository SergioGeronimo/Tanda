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
import com.tanda.DB.Persona;
import com.tanda.DB.Tanda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sergio Gerónimo
 */
public class ViewPagos extends HttpServlet {

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
            
            Connection conx = JConnector.conectDB();
            Tanda selectedTanda = TandaDAO.getTanda(Integer.valueOf(request.getParameter("ID_TANDA")), conx);
            
            Vector<Pago> allPagos = PagoDAO.getAllPagos(selectedTanda.getIdTanda(), conx);
            Vector<Persona> allDeudores = PagoDAO.getAllDeudores(allPagos, conx);
            
            request.setAttribute("allPagos", allPagos);
            request.setAttribute("allDeudores", allDeudores);
            request.setAttribute("tanda", selectedTanda);
            
        }catch(NullPointerException nullEx){
            nullEx.printStackTrace();
        }
        
        request.getRequestDispatcher("/view/pagos.jsp").forward(request, response);
        
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
