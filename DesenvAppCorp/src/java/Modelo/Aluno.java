/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author guilherme
 */
@Entity
public class Aluno extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long ID;
    private String matricula;
    private float CR;
    @Temporal(TemporalType.DATE)
    private Date dataIngresso;
    @OneToMany
    private List<Projeto> projetos;

    public Aluno(Date dataIngresso, String nome, String matricula, String email, String CPF, String endereco) {
        super(nome, email, CPF, endereco);
        this.dataIngresso = dataIngresso;
        this.matricula = matricula;
    }

    public Aluno() {
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getCR() {
        return CR;
    }

    public void setCR(float CR) {
        this.CR = CR;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

}
