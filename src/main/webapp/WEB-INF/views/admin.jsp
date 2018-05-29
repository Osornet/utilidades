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
    <h1>Admin.jsp</h1>
    <form:form action="${pageContext.request.contextPath}/admin/save" method="post" modelAttribute="admin">
        <table>
            <c:if test="${admin.idAd ne 0}">
                <form:input type="hidden" path="idAd"/>
                <form:input type="hidden" path="fechaCreacion"/>        
            </c:if>
            <tr>
                <td>Estado:</td>
                <td><input type="text" name = "estado"/></td>
            </tr>
            <tr>
                <td>nombre</td>
                <td><form:input type="text" path="nombre"/></td>
            </tr>
            <tr>
                <td>Cargo</td>
                <td><form:input type="text" path="cargo"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Guardar Cambios"/></td>
            </tr>
        </table>
    </form:form>
    <c:out value="${resultado}"/><br/>

    <c:forEach var="admin" items="${admins}">
        <c:out value="${admin}"/>
        <a href="<c:url value='/admin/${admin.idAd}/update'/>">Actualizar</a>
        <a class="confirm" href="<c:url value='/admin/${admin.idAd}/delete'/>">Eliminar</a>
        <br/>
    </c:forEach>
</body>
</html>