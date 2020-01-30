/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Emiliano
 */
@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet {
    
    //@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String metodoHTTP = request.getMethod();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Header HTTP</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Headers HTTTP </h1>");
        
        out.print("</br>");
        out.print("<Metodo HTTP:>" + metodoHTTP);
        
        out.print("</br>");
        String uri = request.getRequestURI();
        out.print("Uri: " + uri);
        
        out.print("<br>");
        out.print("<br>");
        Enumeration cabeceros = request.getHeaderNames();
        while(cabeceros.hasMoreElements()){
            String nombreCabecero = cabeceros.nextElement().toString();
            out.print("<b> "+ nombreCabecero + "</b>:");
            out.print(request.getHeader(nombreCabecero));
            out.print("<br>");
        }
        
        out.print("<html>");
        out.print("</body>");
        out.print("</html>");
        out.close();
        
    }
    
}
