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
    </head>
    <body>
        <div>
            <h2>Users</h2>
            <table border="1">
                <thead>
                <th>code</th>
                <th>name</th>
                    <c:forEach var="barco" items="${barcos}">
                    <tr>
                        
                       
                        <td>${barco.name}</td>
                    </tr>
                </c:forEach>
            </table>
         
        </div>
    </body>
</html>
