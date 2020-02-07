<%-- 
    Document   : Scriplets
    Created on : 06/02/2020, 21:46:05
    Author     : Emiliano
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriplets</title>
    </head>
    <body>
        <h1>JSP con Scriplets</h1>
        <br>
        <%-- Scriplet para enviar informacion al navegador --%>
        <%
            out.print("Saludos desde un scriplet");
        %>
        <%-- Scriplet para manipular los objetos implicitos  --%>

        <%
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicacion " + nombreAplicacion);
        %>
        <br>
        <%-- Scriplet con codigo condicionado --%>

        <%
            if (session != null && session.isNew()) {
        %>
        La sesion SI es nueva
        <%             } else if (session != null) {

        %>
        La sesion NO es nueva
        <% }
        %>
        <br>
         <a href="index.html">Inicio</a>   
    </body>
</html>
