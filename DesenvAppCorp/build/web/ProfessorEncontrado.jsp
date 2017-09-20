<%-- 
    Document   : ProfessorEncontrado
    Created on : Sep 13, 2017, 3:41:25 PM
    Author     : Joao Salle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professor Encontrado</title>
    </head>
    <body>
        <h1>Professor Encontrado!</h1>
        <label>Nome:</label><br/>
        <span>${professor.nome}</span><br/><br/>
        <label>Titulação:</label><br/>
        <span>${professor.titulacao}</span><br/><br/>
        <label>CPF:</label><br/>
        <span>${professor.CPF}</span><br/><br/>
    </body>
</html>