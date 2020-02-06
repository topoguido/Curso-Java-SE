<%-- 
    Document   : index
    Created on : 05/02/2020, 20:46:22
    Author     : Emiliano
--%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Hola Mundo JSP's</title>
    </head>
    <body>
        <h1>Hola Mundo JSP's</h1>
        <ul>
            <li><% out.print("Hola mundo con Scriplets"); %> </li>
            <li> ${"Hola mundo con Expression Language (EL)"}  </li>
            <li> <%= "Hola mundo con Expresiones" %> </li>
            <li> <c:out value="Hola Mundo con JSTL" /> </li>
        </ul>
    </body>
</html>
