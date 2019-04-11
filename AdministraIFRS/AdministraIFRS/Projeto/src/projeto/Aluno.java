/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author coelho
 */
public class Aluno {

    private String nome;
    private Curso curso;
    private int anoIngresso;
    private boolean ehFormado;
    private long matricula;

    public Aluno(String nome, Curso curso, int anoIngresso, boolean ehFormado, long matricula) {
        this.nome = nome;
        this.curso = curso;
        this.anoIngresso = anoIngresso;
        this.ehFormado = ehFormado;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public boolean isEhFormado() {
        return ehFormado;
    }

    public void setEhFormado(boolean ehFormado) {
        this.ehFormado = ehFormado;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    
    String verificaStatus() {
        if (ehFormado) {
            return "O aluno ainda não completou os créditos";
        }
        return "O aluno entrou no ano" + anoIngresso + "e se formou";
    }

    long obtemMatricula() {
        return matricula;
    }
}
