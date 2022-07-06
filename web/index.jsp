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
    <h1>Insira seu login e senha abaixo: </h1>
    <form action="autenticar" method="post">
        <label for="login">Login</label>
        <input type="text" name="login" id="login" class="entradas">

        <label for="Senha">Senha</label>
        <input type="password" name="senha" id="Senha" class="entradas">

        <input type="submit" value="Entrar" class="botao">
    </form>
</body>
</html>