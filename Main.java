import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SistemaAvaliacao sistema = new SistemaAvaliacao();

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE AVALIAÇÃO DE DISCIPLINA - POO ║");
        System.out.println("╚════════════════════════════════════════════╝");

        int opcao;
        do {
            System.out.println("\n─────── MENU PRINCIPAL ───────");
            System.out.println("1. Registrar novo aluno");
            System.out.println("2. Registrar nota de recuperação");
            System.out.println("3. Processar recuperações");
            System.out.println("4. Relatório de aluno específico");
            System.out.println("5. Relatório de alunos em recuperação");
            System.out.println("6. Relatório geral do sistema");
            System.out.println("7. Sair");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        registrarAluno();
                        break;
                    case 2:
                        registrarNotaRecuperacao();
                        break;
                    case 3:
                        sistema.processarRecuperacoes();
                        break;
                    case 4:
                        relatórioAlunoEspecífico();
                        break;
                    case 5:
                        sistema.obterAlunosRecuperacao().gerar();
                        break;
                    case 6:
                        sistema.gerar();
                        break;
                    case 7:
                        System.out.println("\n👋 Encerrando sistema...\n");
                        break;
                    default:
                        System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Erro: " + e.getMessage());
                scanner.nextLine();
                opcao = -1;
            }
        } while (opcao != 7);

        scanner.close();
    }

    private static void registrarAluno() {
        System.out.println("\n━━━ REGISTRO DE ALUNO ━━━");
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        System.out.print("Frequência (%): ");
        double frequencia = scanner.nextDouble();
        scanner.nextLine();

        Aluno aluno = new Aluno(nome, matricula, frequencia);

        System.out.println("\n─ AVALIAÇÕES DO 1º BIMESTRE ─");
        registrarAvaliacoesBimestre(aluno, true);

        System.out.println("\n─ AVALIAÇÕES DO 2º BIMESTRE ─");
        registrarAvaliacoesBimestre(aluno, false);

        sistema.adicionarAluno(aluno);
        aluno.gerar();

        System.out.println("✓ Aluno registrado com sucesso!");
    }

    private static void registrarAvaliacoesBimestre(Aluno aluno, boolean primeiro) {
        System.out.print("Quantas avaliações? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Nome da avaliação " + i + ": ");
            String nomeAvaliacao = scanner.nextLine();
            System.out.print("Nota (0-10): ");
            double nota = scanner.nextDouble();
            scanner.nextLine();

            if (primeiro) {
                aluno.adicionarAvaliacaoPrimeiroBimestre(nomeAvaliacao, nota);
            } else {
                aluno.adicionarAvaliacaoSegundoBimestre(nomeAvaliacao, nota);
            }
        }
    }

    private static void registrarNotaRecuperacao() {
        System.out.println("\n━━━ REGISTRAR NOTA DE RECUPERAÇÃO ━━━");
        System.out.print("Matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = sistema.obterTodosAlunos().stream()
            .filter(a -> a.getMatricula() == matricula)
            .findFirst()
            .orElse(null);

        if (aluno == null) {
            System.out.println("❌ Aluno não encontrado!");
            return;
        }

        if (!aluno.temDireitoRecuperacao()) {
            System.out.println("❌ Aluno não tem direito a recuperação!");
            return;
        }

        System.out.print("Nota de recuperação (0-10): ");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        try {
            aluno.registrarNotaRecuperacao(nota);
            System.out.println("✓ Nota registrada com sucesso!");
            aluno.gerar();
        } catch (IllegalStateException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }

    private static void relatórioAlunoEspecífico() {
        System.out.println("\n━━━ RELATÓRIO DE ALUNO ━━━");
        System.out.print("Matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = sistema.obterTodosAlunos().stream()
            .filter(a -> a.getMatricula() == matricula)
            .findFirst()
            .orElse(null);

        if (aluno == null) {
            System.out.println("❌ Aluno não encontrado!");
        } else {
            aluno.gerar();
        }
    }
}