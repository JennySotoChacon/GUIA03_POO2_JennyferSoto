<%-- 
    Document   : index
    Created on : 24-ago-2016, 23:01:02
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LugaAcceServ" method="Post">
            <div class="container">
                <h2>Usando JPA [Lugares de Acceso]</h2>
                <div class="form-group">
                    <label for="nomb">Nombre: </label>
                    <input type="text" name="nomb" value=""/>
                </div>
                <div class="btn-group">
                    <input type="submit" name="lugaAcceBton" value="Guardar" class="btn btn-default" />
                </div>
            </div>
        </form>
    </body>
</html>
