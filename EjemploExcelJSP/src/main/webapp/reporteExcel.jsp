<%@page import="java.util.Calendar"%>
<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>
<%@page import="utilerias.conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
    %>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de excel</title>
    </head>
    <body>
        <h1>Reporte de excel</h1>
        <br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            
                <td>1.Fundamentos de Java</td>
                <td>Aprendemos la sintaxis basica de Java</td>
                <% Calendar cal = new Calendar.Builder().build(); %>;
                <td><%= conversiones.format(new Date()) %></td>
            
            <tr>
                <td>2. Programacion en Java</td>
                <td>Pondremos en practica conceptos de la programacion orientada a objetos</td>
                <td><%= conversiones.format(new Date())  %></td>
            </tr>
        </table>
    </body>
</html>
