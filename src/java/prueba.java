/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sergio Gerónimo
 */
public class prueba extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/event-stream, charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        while(true){
            Date date = new Date();
            out.print("event: server-time\n");
            out.print("data: " + date.toString() +"\n\n" );
            out.flush();

            try{
                Thread.sleep(10000);
            }catch (InterruptedException inteEx){
                inteEx.printStackTrace();
            }
        }
    }
    
    
}
