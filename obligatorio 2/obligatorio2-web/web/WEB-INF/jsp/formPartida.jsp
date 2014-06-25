<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Barco</title>
        <title>Agregar Barco</title>
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
                    <li class="active"><a href="<%=request.getContextPath()%>/arribo/listArribos.htm">Arribos</a></li>
                    <li ><a href="<%=request.getContextPath()%>/profiling/listProfiling.htm">Profiling</a></li>
                    <li ><a href="<%=request.getContextPath()%>/tracing/listTracing.htm">Tracing</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="page-header">
            <h1>Ingresar Partida</h1>
        </div>
        <div class="col-lg-12">
            <div class="well bs-component">
                <form:form modelAttribute="partida" action="agregarPartida.htm" method="post" class="form-horizontal">
                    <form:errors path="*" class="alert alert-dismissable alert-danger" style="padding-bottom: 3px;"/>
                    <fieldset>
                        <legend>Campos Partida</legend>
                        <div class="form-group">
                            <form:label for="origen" path="destino" class="col-lg-2 control-label">Destino</form:label>
                                <div class="col-lg-10">
                                <form:input class="form-control" path="destino" />
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label for="fecha" path="fecha" class="col-lg-2 control-label">Fecha</form:label>
                                <div class="col-lg-10">
                                <form:input path="fecha" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label for="descripcion" path="descripcion" class="col-lg-2 control-label">Descripcion</form:label>
                                <div class="col-lg-10">
                                <form:input path="descripcion" class="form-control"/>
                            </div>
                        </div>

                        <div class="bs-component">
                            <h3>Barco</h3>

                            <form:select path="barcoId" items="${barcoList}"  />
                        <div class="bs-component">
                            <h3>Contenedores</h3>
                            
                            <form:select path="contList" items="${contenedorList}"  />
                            
                            <div class="col-lg-10">
                                <div class="form-group">
                                    <div class="col-lg-10 col-lg-offset-2">
                                        <button type="submit" class="btn btn-primary">Agregar</button>
                                    </div>
                                </div>
                            </div>
                    </fieldset>
                </form:form>
            </div>
        </div>
</body>
</html>
