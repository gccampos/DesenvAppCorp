<%-- 
    Document   : ProjetoEncontrado
    Created on : Sep 13, 2017, 3:44:08 PM
    Author     : Joao Salle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto Encontrado</title>
    </head>
    <body>
        <h1>Projeto Encontrado!</h1>
        <label>Título:</label><br/>
        <span>${projeto.titulo}</span><br/><br/>
        <label>Orientador:</label><br/>
        <span>${projeto.idProfessor}</span><br/><br/>
        <label>Orientado:</label><br/>
        <span>${projeto.idAluno}</span><br/><br/>
        <label>Data de Início:</label><br/>
        <span>${projeto.dataInicio}</span><br/><br/>
        <label>Data de Fim:</label><br/>
        <span>${projeto.dataFim}</span><br/><br/>
    </body>
</html>