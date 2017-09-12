/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AlunoDAO;
import Modelo.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "AdicionaAlunoServlet", urlPatterns = {"/AdicionaAlunoServlet"})
public class AdicionaAlunoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        AlunoDAO alunoDAO = new AlunoDAO();
        try (PrintWriter out = response.getWriter()) {

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String endereco = request.getParameter("endereco");
            String cpf = request.getParameter("CPF");
            Date dataIngresso = Calendar.getInstance().getTime();

            Aluno aluno = new Aluno(dataIngresso, nome, email, cpf, endereco);
            alunoDAO.persistirAluno(aluno);

            String erro = "Houve algum problema com seu cadastro! Por favor, preencha o formulário abaixo novamente conforme as recomendações em cada campo.";
            request.setAttribute("erro", erro);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
    }

}
