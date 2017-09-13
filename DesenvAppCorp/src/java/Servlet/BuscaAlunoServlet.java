/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.AlunoDAO;
import Modelo.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guilherme
 */
@WebServlet(name = "BuscaAlunoServlet", urlPatterns = {"/BuscaAlunoServlet"})
public class BuscaAlunoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        AlunoDAO alunoDAO = new AlunoDAO();
        try (PrintWriter out = response.getWriter()) {
            Aluno aluno = null;
            String nome = request.getParameter("nome");

            boolean nomeIsValid = (nome != null);
            if (nomeIsValid) {
                aluno = alunoDAO.buscarPorNome(nome);
            }

            String erro = "Houve algum problema.";
            request.setAttribute("erro", erro);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AlunoEncontrado.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
    }

}
