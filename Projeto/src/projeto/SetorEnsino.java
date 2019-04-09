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
public class SetorEnsino {
    private Aluno alunos[];
    private Curso cursos[];
    private Professor professores[];
    private String diretor;
    private String coordenador;

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }
    
    public SetorEnsino (Curso [] cursos, Professor [] professores, String diretor, String coordenador){
        this.cursos = cursos;
        this.professores = professores;
        this.diretor = diretor;
        this.coordenador = coordenador;
    }
    
    public boolean novoProfessor(String nome, long siape) {
        for (int i = 0; i < professores.length; i++) {
            if (professores[i] != null) {
                String [] areas = new String[10];
                professores[i] = new Professor(nome, areas, siape);
                return true;
            }
        }
        return false;
    }

    public boolean demitirProfessor(long siape) {
        for (int i = 0; i < professores.length; i++) {
            if (professores[i] != null && professores[i].getSiape() == siape) {
                professores[i] = null;
                return true;
            }
        }
        return false;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public Professor[] getProfessores() {
        return professores;
    }

    public void setProfessores(Professor[] professores) {
        this.professores = professores;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }
    public SetorEnsino(String diretor, String coordenador) {
        this.diretor = diretor;
        this.coordenador = coordenador;
        alunos = new Aluno[1000];
        professores = new Professor[60];
        cursos = new Curso[20];        
    }
    
    
}
