<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Contenedores</title>
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
                    <li><a href="<%=request.getContextPath()%>/contenedor/listContenedors.htm">Barcos</a></li>
                    <li class="active"><a href="<%=request.getContextPath()%>/contenedor/listContenedores.htm">Contenedores</a></li>
                    <li><a href="<%=request.getContextPath()%>/partida/listPartidas.htm">Partidas</a></li>
                    <li><a href="<%=request.getContextPath()%>/arribo/listArribos.htm">Arribos</a></li>
                    <li ><a href="<%=request.getContextPath()%>/profiling/listProfiling.htm">Profiling</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="page-header">
            <h1>Contenedores</h1><a href="formContenedor.htm" style="float:right;" class="btn btn-primary">Agregar</a>
        </div>

        <div class="bs-component">
            <table class="table table-striped table-hover ">

                <thead>
                <th>Codigo</th>
                <th>Capacidad</th>
                <th>Marca</th>
                <th>Modelo</th>
                    <c:forEach var="contenedor" items="${contenedores}">
                    <tr>              
                        <td>
                            <spring:url value="editarContenedor-{contenedorId}.htm" var="contenedorUrl">
                                <spring:param name="contenedorId" value="${contenedor.id}"/>
                            </spring:url>
                            <a href="${contenedorUrl}">${contenedor.codigo}</a></td>
                        <td>${contenedor.capacidad}</td>
                        <td>${contenedor.marca}</td>
                        <td>${contenedor.modelo}</td>
                        <td>
                            <spring:url value="eliminarContenedor-{contenedorId}.htm" var="contenedorEliminarUrl">
                                <spring:param name="contenedorId" value="${contenedor.id}"/>
                            </spring:url>
                            <a href="${contenedorEliminarUrl}" style="text-decoration: none">X</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
