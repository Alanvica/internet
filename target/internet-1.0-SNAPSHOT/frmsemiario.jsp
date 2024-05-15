<%-- 
    Document   : frmsemiario
    Created on : 14 may. 2024, 22:19:34
    Author     : Villalba
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1>
            <c:if test="${seminario.id == 0}">Nuevo</c:if>
            <c:if test="${seminario.id != 0}">Editar</c:if>
                Estudiante
            </h1>
            <form action="inicio" method="post">
                <input type="hidden" name="id" value="${seminario.id}"/>
            <table>
                <tr>
                    <td>Nombres: </td>
                    <td><input type="text" name="nombres" value="${seminario.nombre}"></td>
                </tr>
                <tr>
                    <td>Apellidos: </td>
                    <td><input type="text" name="apellidos" value="${seminario.apellidos}"></td>
                </tr>
                <tr>
                    <td>Seminario: </td>
                    <td><input type="text" name="seminario" value="${seminario.seminarios}"></td>
                </tr>
                <tr>
                    <td>Confirmado: </td>
                    <td>
                        <input type="checkbox" name="confimado" id="che">
                    </td>
                </tr>
                <tr>
                    <td>Fecha: </td>
                    <td><input type="date" name="fecha" value="${seminario.fecha}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"></td>
                </tr>
            </table>
        </form>
        <c:if test="${item.confimado == 'on'}">
            <script>
                document.getElementById("che").checked = true;
            </script>
        </c:if>
        <c:if test="${item.confimado != 'on'}">
            <script>
                document.getElementById("che").checked = false;
            </script>
        </c:if>

    </body>
</html>
