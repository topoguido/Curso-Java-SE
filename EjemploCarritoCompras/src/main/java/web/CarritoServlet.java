/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Emiliano
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
         response.setContentType("text/html;charset=UTF-8");

        // creamos o recuperamos el objeto httpsession
        HttpSession sesion = request.getSession();

        //Recuperamos lista de articulos si es que existen
        List<String> listaArticulos = (List<String>) sesion.getAttribute("articulo");

        // verificamos si la lista de articulos existe
        if (listaArticulos == null) {

            // con esto inicializamos la lista
            listaArticulos = new ArrayList<>();

            sesion.setAttribute("articulo", listaArticulos);
        }
        
        //procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");

        //revisamos el articulo y lo agregamos
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            listaArticulos.add(articuloNuevo);
        }

        try ( // imprimimos la lista de articulos
                PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de articulos</h1>");
            out.print("<br>");

            //iteramos todos los articulos
            for (String articulo : listaArticulos) {
                out.print("<li>" + articulo + "</li>");
            }
            out.print("<br>");
            out.print("<a href='/EjemploCarritoCompras'>Regresar al inicio</a>");
        }
    }
}
