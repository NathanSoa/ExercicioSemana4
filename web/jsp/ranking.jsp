<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Anek+Malayalam:wght@400;700&display=swap" rel="stylesheet">
<title>Ranking</title>
</head>
<body>
    <h1>Ranking dos nossos usuários</h1>
    <main>
        <c:set var="colocacao" scope = "request" value = "${1}"/>
        <table>
            <thead>
                <tr>
                   <th>Colocação</th>
                   <th>Nome</th>
                   <th>Login</th>
                   <th>Pontos</th>
                </tr>         
            </thead>
            <tbody>
                <c:forEach var="item" items="${ranking}"> 
                    <tr>
                        <td><c:out value="${colocacao}"/></td>
                        <c:set var="colocacao" scope="request" value="${colocacao + 1}"/>
                        <td><c:out value="${item.nome}"/></td>
                        <td><c:out value="${item.login}"/></td>
                        <td><c:out value="${item.pontos}"/></td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>