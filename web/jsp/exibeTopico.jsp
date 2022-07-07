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
    <main>
        <h1>
            <c:out value="${topico.titulo}"/>
        </h1>
        <h3>
            Autor: <c:out value="${topico.usuario}"/>
        </h3>
        <p>
            <c:out value="${topico.conteudo}"/>
        </p>
        <c:forEach var="comentario" items="${comentarios}">
            <section class="comentario">
                <p>${comentario.comentario}</p>
                <p> &nbsp;&nbsp;&nbsp;&nbsp;-${comentario.usuario}</p>
            </section>
        </c:forEach>

        <section id="formComentario">
            <h2>Faça seu comentário: </h2>
            <br/>
            <form action="comentar?codigo=${codigo}" method="post">
                <textarea name="comentario" rows="10" cols="90"></textarea> 
                
                <input type="submit" value="comentar" class="botao"/>
            </form>
        </section>
    </main>
                
    <footer>
        <a href="javascript:history.go(-1)" class="botao">Voltar para a página de tópicos</a>
    </footer>
</body>
</html>