<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div>
            <h2>Login</h2>
        </div>
        <div class="col-lg-6">
            <div class="well bs-component">
                <form:form modelAttribute="trace" action="setear.htm" method="post" class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <form:label for="nombre" path="nombre" class="col-lg-2 control-label">Nombre de usuario</form:label>
                            
                            <div class="col-lg-10">
                            <form:input class="form-control" path="nombre" />
                        </div>
                        <div class="col-lg-10">
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </body>
</html>
