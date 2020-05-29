
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>El y variables implicitas</title>
    </head>
    <body>
        <h1>EL y variables implicitas</h1>
        <ul>
            <li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
            <li>Navegador: ${header["User-agent"]}</li>
            <li>Id sesion: ${cookie.JSESSIONID.value}</li>
            <li>webserver: ${pageContext.servletConfig.servletContext.serverInfo}</li>
            <li>Valor parametro: ${param.usuario}</li>
        </ul>
        <br>
        <br>
        <a href="index.jsp">volver a inicio</a>
    </body>
</html>
