/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emiliano
 */
@WebServlet("/HolaMundo")

public class HolaMundo extends HttpServlet {    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("Hola mundo desde servlet");
        
    }
  
}
