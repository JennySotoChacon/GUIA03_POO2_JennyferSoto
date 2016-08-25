<%-- 
    Document   : TipoGafe
    Created on : 25-ago-2016, 10:13:43
    Author     : Owner
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Guia03-POO2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'/>
        <script type='text/javascript' src='webjars/jquery/2.1.4/jquery.min.js'></script>
        <script type='text/javascript' src='webjars/bootstrap/3.2.0/js/bootstrap.min.js'></script>
    </head>
    <body>
        <form action="TipoGafeServ" method="Post">
            <div class="container">
                <h2>Usando JPA [Tipo de gafete]</h2>
                <div class="form-group">
                    <label for="nomb">Nombre: </label>
                    <input type="text" name="nomb" value=""/>
                </div>
                <div class="btn-group">
                    <input type="submit" name="tipoGafeBton" value="Guardar" class="btn btn-default" />
                </div>
            </div>
            <div class="panel panel-default"style="padding: 15px;">
                    <jsp:useBean id="TipoGafeCtrl" class="com.sv.udb.controlador.TipoGafeCtrl" scope="page"/>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Fecha Alta</th>
                                 <th>Seleccione</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${TipoGafeCtrl.ConsTodo()}" var="fila">
                                <tr>
                                    <td><c:out value="${fila.nombTipoGafe}"></c:out></td>
                                    <td><c:out value="${fila.fechAlta}"></c:out></td>
                                    <td> <input type="radio" name="codiRadi" value="${fila.codiTipoGafe}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </div>
            
        </form>
    </body>
</html>
