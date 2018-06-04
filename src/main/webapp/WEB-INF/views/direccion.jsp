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
    <title>Direccion</title>
</head>
<body>
    <c:import url="/WEB-INF/views/menu.jsp"/>
    <h1>Agregar Direcciones <c:out value="${sessionScope.admin.nombre}"/></h1>
    
    <form:form action="${pageContext.request.contextPath}/direccion/save" method="post" modelAttribute="direccion">
        <table>
            <c:if test="${direccion.idDir ne 0}">
                <form:input type="hidden" path="idDir"/>
            </c:if>
            <tr>
                <td>Calle</td>
                <td><form:input type="text" path="calle"/></td>
            </tr>
            <tr>
                <td>CP</td>
                <td><form:input type="text" path="cp"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Guardar Cambios"/></td>
            </tr>
        </table>
    </form:form>
    <c:out value="${resultado}"/><br/>

    <c:forEach var="direccion" items="${direcciones}">
        <c:out value="${direccion}"/>
        <a href="<c:url value='/direccion/${direccion.idDir}/update'/>">Actualizar</a>
        <a class="confirm" href="<c:url value='/direccion/${direccion.idDir}/delete'/>">Eliminar</a>
        <br/>
    </c:forEach>
    <a href="<c:url value='/admin'/>">volver a admin</a>
</body>
</html>