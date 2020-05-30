
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.rectangulo;

@WebServlet("/ServletControlador") 
public class ServletControlador extends HttpServlet {
    @Override 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. Procesamos los parametros
        //2. Crear java beans
        rectangulo rec = new rectangulo(3,6);
        
        //3. Agregar java bean a algun alcance
        request.setAttribute("mensaje", "saludos desde el servlet");
        
        HttpSession sesion = request.getSession(); 
        sesion.setAttribute("rectangulo", rec);
        
        //4. Redireccionar a la vista seleccionada
        
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(request, response);
    }
    
    
}
