/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluno;
import Modelo.Projeto;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guilherme
 */
public class ProjetoDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

    public void persistirProjeto(Projeto projeto) throws SQLException {
        EntityManager em = factory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(projeto);
        et.commit();
        em.close();
    }

    public Projeto buscarPorTitulo(String titulo) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("Select p from Projeto p where p.titulo = :titulo");
        query.setParameter("titulo", titulo);
        Projeto projeto = (Projeto) query.getSingleResult();
        em.close();
        return projeto;
    }

    public List<Projeto> ListarProjetosProfessor(long idProfessor) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("Select * from Projeto p where p.idProfessor = :idProfessor");
        query.setParameter("idProfessor", idProfessor);
        List<Projeto> projetos = (List<Projeto>) query.getResultList();
        em.close();
        return projetos;
    }

    public List<Projeto> ListarProjetosAluno(long idAluno) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("Select * from Projeto p where p.idProfessor = :idAluno");
        query.setParameter("idProfessor", idAluno);
        List<Projeto> projetos = (List<Projeto>) query.getResultList();
        em.close();
        return projetos;
    }
}
