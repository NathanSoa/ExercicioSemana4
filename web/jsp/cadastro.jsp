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
<title>Cadastro</title>
</head>
<body>
    <header>
    <h1 style="color:black;">Faça seu Cadastro!</h1>        
    </header>
    
    <main>
        <h1>Insira suas informações</h1>
        <form action="cadastrar" method="post">
            <label for="login">Login</label>
            <input type="text" name="login" id="login" class="entradas" placeholder="Digite seu login">
    
            <label for="email">Email</label>
            <input type="email" name="email" id="email" class="entradas" placeholder="Digite seu email">
            
            <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" class="entradas" placeholder="Digite seu nome">
            
            <label for="Senha">Senha</label>
            <input type="password" name="senha" id="Senha" class="entradas" placeholder="Digite sua senha">
    
            <input type="submit" value="Entrar" class="botao">
        </form>
    </main>
</body>
</html>