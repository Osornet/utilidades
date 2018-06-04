<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<h2>menú</h2>

<sec:authorize access="!isAuthenticated()">
    Por Favor Inicia Session
    
</sec:authorize>
<sec:authorize access="isRememberMe()">
    El usuario ha iniciado Session Como: 
    <sec:authentication property="principal" var="principal"/>
    <c:set var="username" value="${principal.username}"/>
    <c:out value="${username}"/>
    <br/>
    <a href="<c:url value='/logout'/>">Cerrar Sesión</a>
</sec:authorize>
<sec:authorize access="isFullyAuthenticated()">
    El usuario ha iniciado Session Como: 
    <sec:authentication property="principal" var="principal"/>
    <c:set var="username" value="${principal}"/>
    <c:out value="${username}"/>
    <br/>
    <a href="<c:url value='/logout'/>">Cerrar Sesión</a>
</sec:authorize>
<br/>
<a href="<c:url value='/usuario'/>">Registrar Usuarios</a><br/>
