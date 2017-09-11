/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Projeto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guilherme
 */
public class ProjetoDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

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
