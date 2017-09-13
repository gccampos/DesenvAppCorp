/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluno;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guilherme
 */
public class AlunoDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("AlunoPU");

    public void persistirAluno(Aluno aluno) throws SQLException {
        EntityManager em = factory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(aluno);
        em.flush();
        et.commit();
        em.close();
    }

    public Aluno buscarPorNome(String nome) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("Select a from Aluno a where a.nome = :nome");
        query.setParameter("nome", nome);
        Aluno aluno = (Aluno) query.getSingleResult();
        em.close();
        return aluno;
    }

}
