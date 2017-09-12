/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AlunoDAO;
import DAO.ProfessorDAO;
import DAO.ProjetoDAO;
import Modelo.Aluno;
import Modelo.Professor;
import Modelo.Projeto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "AdicionaProjetoServlet", urlPatterns = {"/AdicionaProjetoServlet"})
public class AdicionaProjetoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        ProjetoDAO projetoDAO = new ProjetoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        AlunoDAO alunoDAO = new AlunoDAO();
        try (PrintWriter out = response.getWriter()) {

            String titulo = request.getParameter("titulo");
            Date dataInicio = new Date(request.getParameter("dataInicio"));
            Date dataFim = new Date(request.getParameter("dataFim"));
            String nomeProfessor = request.getParameter("nomeProfessor");
            String nomeAluno = request.getParameter("nomeAluno");

            Professor professor = professorDAO.buscarPorNome(nomeProfessor);
            Aluno aluno = alunoDAO.buscarPorNome(nomeAluno);

            Projeto projeto = new Projeto(titulo, dataInicio, dataFim, aluno.getID(), professor.getID());

            String erro = "Houve algum problema com seu cadastro! Por favor, preencha o formulário abaixo novamente conforme as recomendações em cada campo.";
            request.setAttribute("erro", erro);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
    }
}
