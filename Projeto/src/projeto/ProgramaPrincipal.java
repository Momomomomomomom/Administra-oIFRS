package projeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author coelho
 */
public class ProgramaPrincipal {

    public static void main(String[] args) throws IOException {
        
        SetorEnsino ensino = new SetorEnsino("Pâmela Perini", "Vitor Valente");
        int opcao = 4;
        
        
        
        do {
            opcao = Integer.parseInt(menu("MENU 1: \n [1] Aluno \n [2] Professor \n [3] Setor de Ensino \n [4] Sair"));
            switch (opcao) {
                case 1:                  
                    menu_alunos("MENU 2: \n [1] Ver Cursos [2] Ver notas", ensino);
                    break;
                case 2:
                    menu_professor("MENU 2: \n [1] Dar Notas de uma disciplina [2] Alterar uma nota [3] Adicionar Área [4] Remover Área", ensino);
                    break;
                case 3:
                    menu_ensino("MENU 2: \n [1] Cadastrar Aluno [2] Cadastrar Curso [3] Adicionar Disciplina ao Curso [4] Cadastrar Professor", ensino);
            }
        } while (opcao != 4);
    }

    private static String menu(String opcoes) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(opcoes);
        String texto = br.readLine();
        return texto;
    }

    private static void menu_alunos(String opcoes, SetorEnsino ensino) throws IOException {
        String nomeAl = menu("Nome do Aluno: "); 
        Aluno aluno = achaAluno(ensino, nomeAl); 
        int opcao = Integer.parseInt(menu(opcoes));
        switch (opcao) {
                case 1:
                    System.out.println("O aluno está ingressado em: "+aluno.getCurso());
                    break;
                case 2:
                    for (int cont = 0; cont < aluno.getCurso().getDisciplinas().length; cont++){
                        for (int cont2 = 0; cont2 < aluno.getCurso().getDisciplinas()[cont].getAlunos().length; cont++){
                            if (aluno.getCurso().getDisciplinas()[cont].getAlunos()[cont2].getNome().equals(aluno.getNome())){
                                System.out.println(aluno.getCurso().getDisciplinas()[cont].getNome()+": "+aluno.getCurso().getDisciplinas()[cont].getNotas()[cont2]);
                            }
                        }
                    }                  
                    
                    System.out.println();
                    break;
            }
    }

    public static Aluno achaAluno(SetorEnsino ensino, String nomeAl) {
        Aluno aluno = new Aluno(null);
        for (int cont = 0; cont < ensino.getAlunos().length; cont++){
            if (nomeAl.equals(ensino.getAlunos()[cont].getNome())){
                aluno = ensino.getAlunos()[cont];
            }
            break;
        }
        return aluno;
    }

    private static void menu_professor(String opcoes, SetorEnsino ensino) throws IOException {
        int opcao = Integer.parseInt(menu(opcoes));
        switch (opcao) {
                case 1:
                    String nomeAl = menu("Aluno: ");
                    String nomeDisc = menu("Disciplina: ");
                    float nota = Float.valueOf(menu("Nota: "));
                    Aluno aluno = achaAluno(ensino, nomeAl);                     
                    Disciplina disciplina = new Disciplina(null);
                    for (int cont = 0; cont < aluno.getCurso().getDisciplinas().length; cont++){
                        if (aluno.getCurso().getDisciplinas()[cont].getNome().equals(nomeDisc)){
                            disciplina = aluno.getCurso().getDisciplinas()[cont];
                        }
                        break;
                    }
                    disciplina.alterarNota(nota, nomeAl);
                    
        }
    }

    private static void menu_ensino(String opcoes, SetorEnsino ensino) throws IOException {
        int opcao = Integer.parseInt(menu(opcoes));
        switch (opcao) {
                case 1:
                    Aluno [] alunos = ensino.getAlunos();
                    for (int cont = 0; cont < alunos.length; cont++) {
                        if (alunos[cont] == null){
                            String nomeAluno = menu("Nome do aluno: ");
                            int anoIngresso = Integer.parseInt(menu("Ano de ingresso: "));
                            boolean ehformado = false;
                            long matricula = Integer.parseInt(menu("Matricula: "));
                            String nomeCurso = menu("Curso: ");
                            for (int cont2 = 0; cont < ensino.getCursos().length; cont++){
                                if (ensino.getCursos()[cont2].equals(nomeCurso)) {
                                     alunos[cont] = new Aluno(nomeAluno, ensino.getCursos()[cont2], anoIngresso, ehformado, matricula);
                                }
                            break;
                            }
                        }
                    }
                    break;
                case 2:
                    Curso []cursos = ensino.getCursos();
                    for (int cont = 0; cont < cursos.length; cont++) {
                        if (cursos[cont] == null){
                            String nomeCurso = menu("Nome do curso: ");
                            String ppc = menu("PPC do Curso: \n");
                            int quanDisciplina = Integer.parseInt(menu("Quantidade de Disciplinas: "));
                            Disciplina [] disciplinas = new Disciplina[quanDisciplina];
                            for (int cont2 = 0; cont < quanDisciplina; cont++) {
                                Disciplina disciplina = novaDisciplina(ensino, cont);
                                disciplinas[cont] = disciplina;
                            }
                            cursos[cont] = new Curso(nomeCurso, ppc, disciplinas);
                            break;
                        }
                    }
                    break;
                case 3:
                    String nomeCurso = menu("Curso: ");
                    for (int cont = 0; cont < ensino.getCursos().length;cont++) {
                        if (ensino.getCursos()[cont].getNome().equals(nomeCurso)){
                            for(int cont2 = 0; cont2 < ensino.getCursos()[cont].getDisciplinas().length; cont2 ++) {
                                if (ensino.getCursos()[cont].getDisciplinas()[cont2] == null) {
                                    Disciplina disciplina = novaDisciplina(ensino, cont);
                                    Disciplina []disciplinas = ensino.getCursos()[cont].getDisciplinas();
                                    disciplinas[cont2] = disciplina;
                                    break;
                                }                                
                            } 
                            break;
                        }
                    }
                case 4:
                    Professor []professores = ensino.getProfessores();
                    for (int cont0 = 0; cont0 < professores.length; cont0++) {
                        if (professores[cont0] == null){
                            String nomeProf = menu("Nome: ");
                            long siape = Integer.parseInt(menu("Siape: "));
                            int quanAreas = Integer.parseInt(menu("Quantidade de áreas: "));
                            String [] areas = new String [quanAreas];
                            for (int cont = 0; cont < quanAreas; cont++){
                                areas[cont] = menu("Area "+(cont+1));
                            }
                            professores[cont0] = new Professor(nomeProf, areas, siape);
                        } 
                    }
                    
            }

    }

    public static Disciplina novaDisciplina(SetorEnsino ensino, int cont) throws IOException, NumberFormatException {
        int quantAlunos = Integer.parseInt(menu("Quantidade de Alunos: "));
        String nomeProf = menu("Nome do Professor: ");
        Professor professor = new Professor(null);
        for (int cont3 = 0; cont3 < ensino.getProfessores().length; cont++) {
            if (ensino.getProfessores()[cont3].getNome().equals(nomeProf)) {
                professor = ensino.getProfessores()[cont3];
            }
        }
        String nomeDisc = menu("Nome da disciplina: ");
        int anoDisc = Integer.parseInt(menu("Ano da disciplina: "));
        Disciplina disciplina = new Disciplina(quantAlunos, professor, nomeDisc, anoDisc);
        return disciplina;
    }

}
