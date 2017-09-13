<%-- 
    Document   : DisciplinaEncontrada
    Created on : Sep 13, 2017, 3:44:00 PM
    Author     : Joao Salle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disciplina Encontrada</title>
    </head>
    <body>
        <h1>Disciplina Encontrada!</h1>
        <label>Nome:</label><br/>
        <span>${disciplina.nome}</span><br/><br/>
        <label>Código:</label><br/>
        <span>${disciplina.codigo}</span><br/><br/>
        <label>Identificação do Professor:</label><br/>
        <span>${disciplina.idProfessor}</span><br/><br/>
    </body>
</html>