
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        
        String accion = request.getParameter("accion");
        
        //2. Crear java beans
        rectangulo recRequest = new rectangulo(1,2);
        rectangulo recSesion = new rectangulo(3,4);
        rectangulo recAplicacion = new rectangulo(5,6);
        
        //3. Agregar java bean a algun alcance
        // revisamos la accion proporcionada.
        if("agregarVariables".equals(accion)){
            // Alcance de request
            request.setAttribute("rectanguloRequest", recRequest);
            
            // alcence de session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion", recSesion);
            
            // Alcance de aplication
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloAplicacion", recAplicacion);
            
            // Agegamos mensaje
            request.setAttribute("mensaje", "las variables fueron agregadas");
            // redireccionamos al index
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if("listarVariables".equals(accion)){
            //4. Redireccionamos al JSP que despliega las variables.
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        }
        else{
            //4. redireccionamos a la pagina de inicio
            request.setAttribute("mensaje", "accion no proporcionada");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        //Esta linea no agregaria informacion al jsp ya que no propaga
        // los objetos request y response
        //response.sendRedirect("index.jsp");
    }
    
    
}
