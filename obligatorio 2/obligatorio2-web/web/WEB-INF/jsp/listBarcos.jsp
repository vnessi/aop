<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Barcos</title>
        <link type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet"/>

    </head>
    <body>
        <div class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Puertos Callao</a>
            </div>
            <div class="navbar-collapse collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="<%=request.getContextPath()%>/barco/listBarcos.htm">Barcos</a></li>
                    <li><a href="<%=request.getContextPath()%>/contenedor/listContenedores.htm">Contenedores</a></li>
                    <li><a href="<%=request.getContextPath()%>/partida/listPartidas.htm">Partidas</a></li>
                    <li><a href="<%=request.getContextPath()%>/arribo/listArribos.htm">Arribos</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="page-header">
            <h1>Barcos</h1><a href="formBarco.htm" style="float:right;" class="btn btn-primary">Agregar</a>
        </div>

        <div class="bs-component">
            <table class="table table-striped table-hover ">

                <thead>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Bandera</th>
                <th>Cantidad de tripulantes</th>
                <th>Capacidad de transporte</th>
                <th>Anio de Fabricacion</th>
                    <c:forEach var="barco" items="${barcos}">
                    <tr>              
                        <td>
                            <spring:url value="editarBarco-{barcoId}.htm" var="barcoUrl">
                                <spring:param name="barcoId" value="${barco.id}"/>
                            </spring:url>
                            <a href="${barcoUrl}">${barco.codigo}</a></td>
                        <td>${barco.nombre}</td>
                        <td>${barco.bandera}</td>
                        <td>${barco.cantidadTripulantes}</td>
                        <td>${barco.capacidadTransporte}</td>
                        <td>${barco.anioFabricacion}</td>
                        <td>
                            <spring:url value="eliminarBarco/{barcoId}.htm" var="barcoUrl">
                                <spring:param name="barcoId" value="${barco.id}"/>
                            </spring:url>
                            <a href="${barcoUrl}">x</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
