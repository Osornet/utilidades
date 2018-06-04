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
    <title>Login</title>
</head>

<body>
    <h1>Acceso a usuarios</h1>
    <form name="f" method="post">
        <table>
            <c:if test="${param.error != null}">
                <tr>
                    <td>Error de Credenciales</td>
                </tr>
            </c:if>
            
            <tr>
                <td>Usuario:</td>
                <td>
                    <input type="text" value="" name="usuario" />
                </td>
            </tr>
            <tr>
                <td>Contraseña:</td>
                <td>
                    <input type="password" value="" name="clave" />
                </td>
            </tr>
            <tr>
                <td>Recordarme:</td>
                <td>
                    <input type="checkbox" id="remember-me" name="remember-me" checked="checked"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="iniciar session">
                </td>
            </tr>
        </table>
    <form>
</body>

</html>