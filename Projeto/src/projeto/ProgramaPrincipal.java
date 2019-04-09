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
                            }
                        }
                    }
                    break;
                case 2:
                    ;
                    break;
            }

    }

}
