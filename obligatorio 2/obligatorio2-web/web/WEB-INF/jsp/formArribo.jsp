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
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="page-header">
            <h1>Ingresar Arribo</h1>
        </div>
        <div class="col-lg-6">
            <div class="well bs-component">
                <form:form modelAttribute="arribo" action="agregarArribo.htm" method="post" class="form-horizontal">
                    <form:errors path="*" class="alert alert-dismissable alert-danger" style="padding-bottom: 3px;"/>
                    <fieldset>
                        <legend>Campos Arribo</legend>
                        <div class="form-group">
                            <form:label for="origen" path="origen" class="col-lg-2 control-label">Origen</form:label>
                                <div class="col-lg-10">
                                <form:input class="form-control" path="origen" />
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
                                        <td>${barco.codigo}</td>
                                        <td>${barco.nombre}</td>
                                        <td>${barco.bandera}</td>
                                        <td>${barco.cantidadTripulantes}</td>
                                        <td>${barco.capacidadTransporte}</td>
                                        <td>${barco.anioFabricacion}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>

                        <div class="bs-component">
                            <h3>Contenedor</h3>
                            <table class="table table-striped table-hover ">

                                <thead>
                                <th>Codigo</th>
                                <th>Capacidad</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                    <c:forEach var="contenedor" items="${contenedores}">
                                    <tr>              
                                        <td>${contenedor.codigo}</td>
                                        <td>${contenedor.capacidad}</td>
                                        <td>${contenedor.marca}</td>
                                        <td>${contenedor.modelo}</td>
                                    </tr>
                                </c:forEach>
                                    
                            </table>
                            
                            
                            <!--http://stackoverflow.com/questions/15480397/how-to-send-list-of-object-to-view-and-back-to-post-method-in-controller-->
                                    <!--http://developer.ucsd.edu/develop/user-interface/building-a-form/form-binding-with-collections.html-->
                            <%--<c:forEach items="${contenedores.contenedor}" varStatus="vs">--%>
                                <%--<c:forEach var="contenedor" items="${contenedores}" varStatus="status">--%>
                                    <%--<form:input path="contenedor[${status.index}].index" name="FName" id="FName" value="" />--%>
                                    <%--<form:input path="contenedor[${status.capacidad}].capacidad" name="capacidad" id="capacidad" value="" />--%>
                                    <%--<form:input path="contenedor[${status.marca}].codigo" name="FName" id="FName" value="" />--%>
                                    <%--<form:input path="contenedor[${status.modelo}].capacidad" name="LName" id="LName" value="" />--%>
                                <%--</c:forEach>--%>
                            <%--</c:forEach>--%>


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
            <div class="col-lg-6">
                
            </div>
</body>
</html>
