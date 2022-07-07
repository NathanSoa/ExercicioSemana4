<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/style.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Anek+Malayalam:wght@400;700&display=swap" rel="stylesheet">
<title>Criar novo tópico</title>
</head>
<body>
    <header>
    <h1>Crie um novo tópico!</h1>        
    </header>
    
    <main>
        <form action="../criarTopico" method="post">
            <label for="titulo">Titulo</label>
            <input type="text" name="titulo" id="titulo" class="entradas" placeholder="Digite o título do tópico">
    
            <label for="conteudo" style="display: block;">Conteúdo</label>
            <textarea name="conteudo" id="conteudo" rows="10" cols="90"></textarea> 
    
            <input type="submit" value="Criar" class="botao">
        </form>
    </main>
    <br/>
    <footer>
        <a href="<c:url value="../main"/>" class="botao">Voltar</a>
    </footer>
</body>
</html>