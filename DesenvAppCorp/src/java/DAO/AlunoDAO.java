/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluno;
import java.sql.SQLException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guilherme
 */
public class AlunoDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

    public void criaAluno(String nome, String matricula, String cpf, String endereco, Date dataIngresso, String email) throws SQLException {
        EntityManager em = factory.createEntityManager();
        Aluno aluno = new Aluno(matricula, 0, dataIngresso);
        aluno.setNome(nome);
        aluno.setCPF(cpf);
        aluno.setEmail(email);
        aluno.setEndereco(endereco);
        em.persist(aluno);
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
