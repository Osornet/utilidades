<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
    <!DOCTYPE html>
    <html lang="es-CO">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Estudio Jstl</title>
    </head>

    <body>
        <form name="Formulario_Compra" action="reenvio.do">

            <p>Artículos a comprar:</p>
            <p>
                <label>
                    <input type="checkbox" name="articulos" value="agua "> Agua </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="leche"> Leche </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="pan"> Pan </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="mazanas"> Manzanas </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="carne"> Carne </label>
                <br>
                <label>
                    <input type="checkbox" name="articulos" value="pescado"> Pescado </label>
            </p>
            <p>
                <input type="submit" name="button" id="button" value="Enviar">
                <br>
            </p>
        </form>
        <h2>Carro de la compra</h2>
        <ul>
            <c:forEach var="categoria" items="${sessionScope.listaDeElementos}">
                <li><c:out value="${categoria}"/></li>
            </c:forEach>
            <li>${sessionScope.mierda}</li>
        </ul>
    </body>

    </html>