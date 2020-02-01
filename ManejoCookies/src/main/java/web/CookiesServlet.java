/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emiliano
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        // suponemos que el usuario visita por primera vez el sitio
        boolean nuevoUsuario = true;
        
        //obtnemos el arreglo de cookies
        Cookie[] cookies = request.getCookies();
        
        //BUSCAMOS SI YA EXISTE UNA COOKIE CREADA ANTERIORMENTE LLAMADA VISITANTE RECURRENTE
        if(cookies != null){
            for (Cookie c: cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    // Ya visitó el sitio. Existe la cookie
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }
        else{
            mensaje = "Gracias por visitar nuevamente el sitio";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mensaje);
        out.close();
    }
    
}
