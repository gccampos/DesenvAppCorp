/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Aluno;
import Modelo.Disciplina;
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
public class DisciplinaDAO {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

    public void persistirDisciplina(Disciplina disciplina) throws SQLException {
        EntityManager em = factory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(disciplina);
        et.commit();
        em.close();
    }

    public Disciplina buscarPorNome(String nome) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("Select d from Disciplina d where d.nome = :nome");
        query.setParameter("nome", nome);
        Disciplina disciplina = (Disciplina) query.getSingleResult();
        em.close();
        return disciplina;
    }

    public Disciplina buscarPorCodigo(String codigo) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("Select d from Disciplina d where d.codigo = :codigo");
        query.setParameter("codigo", codigo);
        Disciplina disciplina = (Disciplina) query.getSingleResult();
        em.close();
        return disciplina;
    }

    public List<Disciplina> ListarDisciplinasProfessor(long idProfessor) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("Select * from Disciplina d where d.idProfessor = :idProfessor");
        query.setParameter("idProfessor", idProfessor);
        List<Disciplina> disciplinas = (List<Disciplina>) query.getResultList();
        em.close();
        return disciplinas;
    }
}
