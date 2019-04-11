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
                    menu_alunos("MENU 2: \n [1] Ver Cursos [2] Ver notas");
                    break;
                case 2:
                    menu_professor("MENU 2: \n [1] Dar Notas de uma disciplina [2] Alterar uma nota [3] Adicionar Área [4] Remover Área");
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

    private static void menu_alunos(String opcoes) throws IOException {
        int opcao = Integer.parseInt(menu(opcoes));
        switch (opcao) {
                case 1:
                    break;
                case 2:
                    ;
                    break;
            }
    }

    private static void menu_professor(String opcoes) throws IOException {
        int opcao = Integer.parseInt(menu(opcoes));

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
