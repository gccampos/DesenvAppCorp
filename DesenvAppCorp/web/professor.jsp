<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professores</title>
    </head>
    <body>
        <h1>Adicionar Professor</h1>
        <form action="AdicionaProfessorServlet" method="POST">
            <label>Nome:</label><br/>
            <input type="text" name="nome"/><br/>
            <label>Email:</label><br/>
            <input type="text" name="email"/><br/>
            <label>Endereço:</label><br/>
            <input type="text" name="endereco"/><br/>
            <label>CPF:</label><br/>
            <input type="text" name="CPF"/><br/><br/>
            <label>Titulação:</label><br/>
            <input type="text" name="titulacao"/><br/><br/>
            <input type="submit" value="Enviar"/>
        </form>

        <h1>Buscar Professor</h1>
        <form action="BuscaProfessorServlet" method="POST">
            <label>Nome:</label><br/>
            <input type="text" name="nome"/><br/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
