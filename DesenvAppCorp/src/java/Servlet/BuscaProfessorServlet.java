/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.ProfessorDAO;
import Modelo.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "BuscaProfessorServlet", urlPatterns = {"/BuscaProfessorServlet"})
public class BuscaProfessorServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            this.processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaProfessorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        ProfessorDAO professorDAO = new ProfessorDAO();
        try (PrintWriter out = response.getWriter()) {
            Professor professor = null;
            String nome = request.getParameter("nome");

            boolean nomeIsValid = (nome != null);
            if (nomeIsValid) {
                professor = professorDAO.buscarPorNome(nome);
                request.setAttribute("professor", professor);

            }

            String erro = "Houve algum problema.";
            request.setAttribute("erro", erro);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProfessorEncontrado.jsp");
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        }
    }
}
