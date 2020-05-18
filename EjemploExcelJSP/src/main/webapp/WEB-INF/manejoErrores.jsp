<%@page isErrorPage = "true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP de manejo de errores</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br>
        Ocurrio una excepcion: <%= exception.getMessage() %> 
        <br>
        <textarea cols="30" rows="5">
        <pre>   
            <% exception.printStackTrace(new PrintWriter(out)); %>;
        </pre>
        </textarea>
    </body>
</html>
