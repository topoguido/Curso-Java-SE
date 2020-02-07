<%-- 
    Document   : procesaFormulario
    Created on : 05/02/2020, 22:23:39
    Author     : Emiliano
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el formulario</h1>
        
        Usuario: <%= request.getParameter("usuario") %>
        <br>
        Password: <%= request.getParameter("password") %>
        <br>
        <br>
        <a href="index.html">Regresar al index</a>
    </body>
</html>
