<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-CO">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>About</title>
</head>
<body>
    <h1>About</h1>
    Atributos del model: <c:out value="${mensaje}"/></br/>
    Atributos de la Session: <c:out value="${sessionScope.resultado}"/><br/>
    Atributos del model: <c:out value="${resultadoAbout}"/></br/>
    Atributos de la Session2: <c:out value="${sessionScope.test}"/>
</body>
</html>