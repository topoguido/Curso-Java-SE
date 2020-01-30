/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author GE0022
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String musica[] = request.getParameterValues("musica");
        String comentarios = request.getParameter("comentario");
        
        out.print("<html>");
        out.print("<head>");
        out.print("<title>");
        out.print("</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el servlet:");
        out.print("</h1>");
        out.print("<table border ='1' >");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario: ");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Password: ");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Tecnologias: ");
        out.print("</td>");
        out.print("<td>");
        for(String tecno: tecnologias){
            out.print(tecno);
            out.print(" / ");
        }
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Genero: ");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupacion: ");
        out.print("</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");
        
        
            out.print("<tr>");
            out.print("<td>");
            out.print("Musica favorita: ");
            out.print("</td>");
            out.print("<td>");
        if(musica != null){
            for(String music: musica){
                out.print(music);
                out.print(" / ");
            }
        }
        else{
            out.print("Valor no proporcionado");
        }
            out.print("</td>");
            out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Comentarios: ");
        out.print("</td>");
        out.print("<td>");
        if(comentarios != null){
            out.print(comentarios);
        }
        else{
            out.print("Valor no proporcionado");
        }
        out.print("</td>");
        out.print("</tr>");
        
        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    }
    
}
