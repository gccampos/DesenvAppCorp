/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Professor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guilherme
 */
public class ProfessorDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

    public Professor buscarPorNome(String nome) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("Select p from Professor p where p.nome = :nome");
        query.setParameter("nome", nome);
        Professor professor = (Professor) query.getSingleResult();
        em.close();
        return professor;
    }

    public Professor criaProfessor(String nome, String endereco, String CPF, String email, String titulacao) {
        EntityManager em = factory.createEntityManager();
        Professor professor = new Professor(titulacao);
        professor.setCPF(CPF);
        professor.setEmail(email);
        professor.setEndereco(endereco);
        professor.setNome(nome);
        em.persist(professor);
        em.close();
        return professor;
        
    }
}
