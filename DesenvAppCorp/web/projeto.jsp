<%-- 
    Document   : projeto
    Created on : Sep 13, 2017, 3:43:49 PM
    Author     : Joao Salle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projetos</title>
    </head>
    <body>
        <h1>Adicionar Projeto</h1>
        <form action="AdicionaProjetoServlet" method="POST">
            <label>Título:</label><br/>
            <input type="text" name="titulo"/><br/>
            <label>Data de Início:</label><br/>
            <input type="text" name="dataInicio"/><br/>
            <label>Data de Fim:</label><br/>
            <input type="text" name="dataFim"/><br/>
            <label>Nome do Orientador:</label><br/>
            <input type="text" name="nomeProfessor"/><br/>
            <label>Nome do Orientado:</label><br/>
            <input type="text" name="nomeAluno"/><br/><br/>
            <input type="submit" value="Enviar"/>
        </form>

        <h1>Buscar Projeto</h1>
        <form action="BuscaProjetoServlet" method="POST">
            <label>Título:</label><br/>
            <input type="text" name="titulo"/><br/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
