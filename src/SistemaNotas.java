import java.util.ArrayList;
import java.util.Scanner;

public class SistemaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();

        while (true) {
        	System.out.println("Menu:");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Editar aluno");
            System.out.println("3. Visualizar boletim dos alunos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.nextLine();

                    System.out.print("Digite o número de matrícula do aluno: ");
                    int matriculaAluno = scanner.nextInt();
                    scanner.nextLine(); 

                    Aluno aluno = new Aluno(nomeAluno, matriculaAluno);

                    while (true) {
                        System.out.print("Digite o nome da disciplina (ou 'sair' para encerrar): ");
                        String nomeDisciplina = scanner.nextLine();

                        if (nomeDisciplina.equalsIgnoreCase("sair")) {
                            break;
                        }

                        Disciplina disciplina = new Disciplina(nomeDisciplina);

                        System.out.print("Digite a média para a disciplina " + nomeDisciplina + ": ");
                        double media = scanner.nextDouble();
                        scanner.nextLine(); 

                        disciplina.registrarNota(media);
                        aluno.adicionarDisciplina(disciplina);
                    }

                    alunos.add(aluno);
                    System.out.println("\nAluno cadastrado com sucesso!\n");
                    break;
                    
                case 2:
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        System.out.print("Digite o número de matrícula do aluno que deseja editar: ");
                        int matriculaEditar = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha pendente

                        boolean alunoEncontrado = false;
                        for (Aluno alun : alunos) {
                            if (alun.getMatricula() == matriculaEditar) {
                                System.out.println("Aluno encontrado:");
                                alun.exibirBoletim();
                                System.out.print("Digite o novo nome do aluno: ");
                                String novoNome = scanner.nextLine();
                                alun.setNome(novoNome);

                                while (true) {
                                    System.out.print("Digite o nome da disciplina para editar (ou 'sair' para encerrar): ");
                                    String nomeDisciplinaEditar = scanner.nextLine();

                                    if (nomeDisciplinaEditar.equalsIgnoreCase("sair")) {
                                        break;
                                    }

                                    boolean disciplinaEncontrada = false;
                                    for (Disciplina disciplina : alun.getDisciplinas()) {
                                        if (disciplina.getNome().equalsIgnoreCase(nomeDisciplinaEditar)) {
                                            System.out.print("Digite a nova média para a disciplina " + nomeDisciplinaEditar + ": ");
                                            double novaMedia = scanner.nextDouble();
                                            scanner.nextLine(); // Consumir a quebra de linha pendente
                                            disciplina.registrarNota(novaMedia);
                                            disciplinaEncontrada = true;
                                            break;
                                        }
                                    }

                                    if (!disciplinaEncontrada) {
                                        System.out.println("Disciplina não encontrada.");
                                    }
                                }

                                System.out.println("Aluno editado com sucesso!");
                                alunoEncontrado = true;
                                break;
                            }
                        }

                        if (!alunoEncontrado) {
                            System.out.println("Aluno com a matrícula " + matriculaEditar + " não encontrado.");
                        }
                    }
                    break;
    
                case 3:
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        System.out.println("Boletim dos alunos cadastrados:");
                        for (Aluno a : alunos) {
                            a.exibirBoletim();
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
