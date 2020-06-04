<html lang="en">
    <head>
        <jsp:include page="WEB-INF/paginas/comunes/inclusionEstilos.jsp"/>

        <title>Control de clientes</title>
    </head>
    <body>
        <!-- Inclusion de cabecero -->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/>
        <!-- fin inclusion cabecero -->

        <!-- seccion de botones de navegacion -->
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        <!-- fin seccion botones de navegacion -->

        <!-- seccion de listado de clientes -->
        <jsp:include page="WEB-INF/paginas/cliente/listadoClientes.jsp"/>
        <!-- fin seccion de listado de clientes -->

        <!-- inclusion de pie -->
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp"/>
        <!-- fin inclusion pie -->

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    </body>
</html>
