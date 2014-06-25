<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Arribos</title>
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
                    <li><a href="<%=request.getContextPath()%>/barco/listBarcos.htm">Barcos</a></li>
                    <li><a href="<%=request.getContextPath()%>/contenedor/listContenedores.htm">Contenedores</a></li>
                    <li><a href="<%=request.getContextPath()%>/partida/listPartidas.htm">Partidas</a></li>
                    <li><a href="<%=request.getContextPath()%>/arribo/listArribos.htm">Arribos</a></li>
                     <li><a href="<%=request.getContextPath()%>/profiling/listProfiling.htm">Profiling</a></li>
                     <li class="active"><a href="<%=request.getContextPath()%>/tracing/listTracing.htm">Tracing</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">

        <div class="page-header">
            <h1>Tracing</h1>
            
            <div class="bs-component">
            <table class="table table-striped table-hover ">

                <thead>
                <th>Fecha</th>
                <th>Descripcion</th>
                </thead>
                
            <c:forEach var="trace" items="${traces}">
                <tr>
                <td>${trace.fecha}</td>
                <td>${trace.descripcion}</td>
                 </tr>
            </c:forEach>
               
            </table>
        </div>
            
    </div>
</div>
</body>
</html>
