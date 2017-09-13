/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.DisciplinaDAO;
import DAO.ProfessorDAO;
import Modelo.Disciplina;
import Modelo.Professor;
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
@WebServlet(name = "AdicionaDisciplinaServlet", urlPatterns = {"/AdicionaDisciplinaServlet"})
public class AdicionaDisciplinaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        try (PrintWriter out = response.getWriter()) {

            String nome = request.getParameter("nome");
            String codigo = request.getParameter("codigo");
            String ementa = request.getParameter("ementa");
            String nomeProfessor = request.getParameter("nomeProfessor");
            Professor professor = professorDAO.buscarPorNome(nomeProfessor);

            Disciplina disciplina = new Disciplina(nome, codigo, ementa, professor.getID());
            disciplinaDAO.persistirDisciplina(disciplina);

            String erro = "Houve algum problema com seu cadastro! Por favor, preencha o formulário abaixo novamente conforme as recomendações em cada campo.";
            request.setAttribute("erro", erro);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
    }
}
