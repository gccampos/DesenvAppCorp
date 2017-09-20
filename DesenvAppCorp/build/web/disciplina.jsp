<%-- 
    Document   : disciplina
    Created on : Sep 13, 2017, 3:43:43 PM
    Author     : Joao Salle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disciplinas</title>
    </head>
    <body>
        <h1>Adicionar Disciplina</h1>
        <form action="AdicionaDisciplinaServlet" method="POST">
            <label>Nome:</label><br/>
            <input type="text" name="nome"/><br/>
            <label>Código:</label><br/>
            <input type="text" name="codigo"/><br/>
            <label>Ementa:</label><br/>
            <input type="text" name="ementa"/><br/>
            <label>Professor Responsável:</label><br/>
            <input type="text" name="nomeProfessor"/><br/>
            <input type="submit" value="Enviar"/>
        </form>

        <h1>Buscar Disciplina</h1>
        <form action="BuscaDisciplinaServlet" method="POST">
            <label>Nome:</label><br/>
            <input type="text" name="nome"/><br/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
