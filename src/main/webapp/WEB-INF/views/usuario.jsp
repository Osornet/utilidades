<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es-CO">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script type="text/javascript" src="<c:url value='/js/jquery-3.3.1.min.js'/>"></script>
    <script type="text/javascript">
        jQuery(document).ready(function(){
            jQuery(".confirm").on("click", function(){
                return confirm("si eliminas este elemento no se podrá recuperar. ¿Confirmar?");
            })
        })
        
    </script>
    <title>Admin</title>
</head>
<body>
    <c:import url="/WEB-INF/views/menu.jsp"/>
    <h1>Admin.jsp</h1>
    <form:form action="${pageContext.request.contextPath}/usuario/save" method="post" modelAttribute="usuario">
        <table>
            <tr>
                <td>Usuario</td>
                <td><form:input type="text" path="usuario"/></td>
            </tr>
            <tr>
                <td>Contraseña</td>
                <td><form:input type="password" path="clave"/></td>
            </tr>
             <tr>
                <td>Permisos</td>
                <td><form:input type="text" path="permiso"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Guardar Cambios"/></td>
            </tr>
        </table>
    </form:form>
    

    <c:forEach var="usuario" items="${usuarios}">
        <c:out value="${usuario.usuario}"/>
        <br/>
    </c:forEach>
</body>
</html>