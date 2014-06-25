<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Partidas</title>
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
                    <li class="active"><a href="<%=request.getContextPath()%>/partida/listPartidas.htm">Partidas</a></li>
                    <li><a href="<%=request.getContextPath()%>/arribo/listArribos.htm">Arribos</a></li>
                     <li ><a href="<%=request.getContextPath()%>/profiling/listProfiling.htm">Profiling</a></li>
                     <li ><a href="<%=request.getContextPath()%>/tracing/listTracing.htm">Tracing</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">

        <form method="GET" action="listPartidas.htm">
            <legend>Listar por mes</legend>
            <div class="form-group">
                <label for="mes" path="mes" class="col-lg-2 control-label">Mes</label>
                <div class="col-lg-10">
                    <input value="" name="mes">
                </div>
            </div>


            <button type="submit" class="btn btn-primary">Buscar</button>
        </form>

        <form method="GET" action="listPartidas.htm">

            <legend>Listar por mes y barco</legend>
            <div class="form-group">
                <label for="mes" path="mes" class="col-lg-2 control-label">Mes</label>
                <div class="col-lg-10">
                    <input value="" name="mes">
                </div>
            </div>
            <div class="form-group">
                <label for="idBarco" path="idBarco" class="col-lg-2 control-label">idBarco</label>
                <div class="col-lg-10">
                    <input value="" name="idBarco">
                </div>
            </div>

            <button type="submit" class="btn btn-primary">buscar</button>
        </form>

        <div class="page-header">
            <h1>Partidas -
                <c:if test="${not empty requestScope.mes}">
                    Mes : ${requestScope.mes}
                </c:if>

                <c:if test="${not empty requestScope.idBarco}">
                    BarcoId : ${requestScope.idBarco} 
                </c:if>
            </h1> <a href="formPartida.htm" style="float:right;" class="btn btn-primary">Agregar</a>
        </div>

        <div class="bs-component">
            <table class="table table-striped table-hover ">

                <thead>
                <th>Destino</th>
                <th>Descripcion</th>
                <th>Fecha</th>
                <th>Barco</th>
                <th>Contenedores</th>
                    <c:forEach var="partida" items="${partidas}">
                    <tr>              
                        <td>${partida.destino}</td>
                        <td>${partida.descripcion}</td>
                        <td>${partida.fecha}</td>
                        <td>${partida.barco.codigo}</td>
                        <td>
                            <c:forEach var="contenedor" items="${partida.contenedores}">
                                ${contenedor.codigo}
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <c:if test="${empty requestScope.idBarco}">
            <a target="_blank" href="<%=request.getContextPath()%>/reporte/partidas.htm?mes=${requestScope.mes}" class="btn btn-info">Generar Reporte</a>
        </c:if>

        <c:if test="${not empty requestScope.idBarco}">
            <a target="_blank" href="<%=request.getContextPath()%>/reporte/partidas.htm?mes=${requestScope.mes}&idBarco=${requestScope.idBarco}" class="btn btn-info">Generar Reporte</a>
        </c:if>
    </div>
</div>
</body>
</html>