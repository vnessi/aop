<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle Barco</title>
    </head>
    <body>
        <div>
            <div>
                <form:form modelAttribute="barco" action="listBarcos.htm" method="get">
                    <fieldset>
                        <legend>Campos Barco</legend>
                        <p>
                            <form:label for="code" path="code">code</form:label><br/>
                            <form:input path="code" disabled="true" />
                        </p>
                        <p>
                            <form:label for="name" path="name">name</form:label><br/>
                            <form:input path="name" disabled="true" />
                        </p>
                        <p>
                            <input type="submit" value="Volver" />
                        </p>
                    </fieldset>
                </form:form>
            </div>            
        </div>
    </body>
</html>
