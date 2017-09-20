<%-- 
    Document   : AlunoEncontrado
    Created on : Sep 13, 2017, 3:23:38 PM
    Author     : Joao Salle
--%>

<%@page import="Modelo.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aluno Encontrado</title>
    </head>
    <body>
        <h1>Aluno Encontrado!</h1>
        <label>Nome:</label><br/>
        <span>${aluno.nome}</span><br/><br/>
        <label>Matricula:</label><br/>
        <span>${aluno.matricula}</span><br/><br/>
        <label>CPF:</label><br/>
        <span>${aluno.CPF}</span><br/><br/>
    </body>
</html>
