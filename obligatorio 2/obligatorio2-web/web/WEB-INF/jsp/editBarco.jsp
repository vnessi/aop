<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Barco</title>
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
                    <li ><a href="<%=request.getContextPath()%>/profiling/listProfiling.htm">Profiling</a></li>
                    <li ><a href="<%=request.getContextPath()%>/tracing/listTracing.htm">Tracing</a></li>
                    
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="page-header">
            <h1>Modificar Barco</h1>
        </div>
        <div class="col-lg-6">
            <div class="well bs-component">
                <form:form modelAttribute="barco" action="modificarBarco.htm" method="post" class="form-horizontal">
                    <form:errors path="*" class="alert alert-dismissable alert-danger" style="padding-bottom: 3px;"/>
                    <fieldset>
                        <legend>Campos Barco</legend>
                            <form:input type="hidden" path="id" value="${barco.id}"/>
                        <div class="form-group">
                            <form:label for="codigo" path="codigo" class="col-lg-2 control-label">Codigo</form:label>
                            
                            <div class="col-lg-10">
                            <form:input class="form-control" path="codigo" value="${barco.codigo}"/>
                        </div>
                        </div>
                        <div class="form-group">
                            <form:label for="nombre" path="nombre" class="col-lg-2 control-label">Nombre</form:label>
                            <div class="col-lg-10">
                            <form:input path="nombre" class="form-control" value="${barco.nombre}"/>
                        </div>
                        </div>
                        <div class="form-group">
                            <form:label for="bandera" path="bandera" class="col-lg-2 control-label">Bandera</form:label>
                            <div class="col-lg-10">
                            <form:input path="bandera" class="form-control" value="${barco.bandera}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label for="capacidadTransporte" path="capacidadTransporte" class="col-lg-2 control-label">Capacidad de Transporte</form:label>
                            <div class="col-lg-10">
                            <form:input path="capacidadTransporte" class="form-control" value="${barco.capacidadTransporte}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label for="cantidadTripulantes" path="cantidadTripulantes" class="col-lg-2 control-label">Cantidad de Tripulantes</form:label>
                            <div class="col-lg-10">
                            <form:input path="cantidadTripulantes" class="form-control" value="${barco.cantidadTripulantes}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label for="anioFabricacion" path="anioFabricacion" class="col-lg-2 control-label">Anio de Fabricacion</form:label>
                            <div class="col-lg-10">
                            <form:input path="anioFabricacion" class="form-control" value="${barco.anioFabricacion}"/>
                            </div>
                        </div>
                        <div class="col-lg-10">
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-primary">Modificar</button>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </div>
        </div>
    </body>
</html>
