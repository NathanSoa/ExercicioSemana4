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
<title>Tópicos</title>
</head>
<body>
    <h1>Bem Vindo ${nome}</h1>
    <main>
        <table>
            <thead>
                <tr>
                   <th>Título</th>
                   <th>Usuário</th>
                </tr>         
            </thead>
            <tbody>
                <c:forEach var="item" items="${topicos}"> 
                        <tr>
                            <td>${item.titulo}</td>
                            <td>${item.usuario}</td>
                            <td><a href="exibeTopico?topico=${item.codigo}" class="botao">Ir para o Tópico</a></td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>