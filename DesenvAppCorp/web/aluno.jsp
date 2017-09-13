<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alunos</title>
    </head>
    <body>
        <h1>Adicionar Aluno</h1>
        <form action="AdicionaAlunoServlet" method="POST">
            <label>Nome:</label><br/>
            <input type="text" name="nome"/><br/>
            <label>Email:</label><br/>
            <input type="text" name="email"/><br/>
            <label>Endereço:</label><br/>
            <input type="text" name="endereco"/><br/>
            <label>Matricula:</label><br/>
            <input type="text" name="matricula"/><br/>
            <label>CPF:</label><br/>
            <input type="text" name="CPF"/><br/><br/>
            <input type="submit" value="Enviar"/>
        </form>

        <h1>Buscar Aluno</h1>
        <form action="BuscaAlunoServlet" method="POST">
            <label>Nome:</label><br/>
            <input type="text" name="nome"/><br/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
