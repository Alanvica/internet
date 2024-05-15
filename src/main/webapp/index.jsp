<%-- 
    Document   : index
    Created on : 14 may. 2024, 21:37:19
    Author     : Villalba
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td> <table>
                        <tr>
                            <td>SEGUNDO PARCIAL TEM-742</td>
                        </tr>
                        <tr>
                            <td>Nombre: Nelson Alan Villalba Castro</td>
                        </tr>
                        <tr> 
                            <td>Carnet: 10069306</td>
                        </tr>
                    </table> </td>
            </tr>
        </table>
        <h1>Registro Día del Internet</h1>
        <p><a href="inicio?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Seminarios</th>
                <th>Confirmado</th>
                <th>Fecha</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${seminario}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.seminarios}</td>
                    <td>
                        <c:if test="${item.confimado == 'on'}"><input type="checkbox" checked disabled></c:if>
                        <c:if test="${item.confimado != 'on'}"><input type="checkbox" disabled></c:if>
                        </td>
                        <td>${item.fecha}</td>
                    <td><a href="inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
