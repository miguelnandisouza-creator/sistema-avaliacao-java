import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Facade que gerencia todo o sistema de avaliação
 */
public class SistemaAvaliacao implements Relatorio {
    private List<Aluno> todosAlunos;
    private AlunosEmRecuperacao alunosRecuperacao;

    public SistemaAvaliacao() {
        this.todosAlunos = new ArrayList<>();
        this.alunosRecuperacao = new AlunosEmRecuperacao();
    }

    public void adicionarAluno(Aluno aluno) {
        todosAlunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        todosAlunos.remove(aluno);
        alunosRecuperacao.removerAluno(aluno);
    }

    public void processarRecuperacoes() {
        System.out.println("\n⚙️  Processando elegibilidade para recuperação...\n");
        
        for (Aluno aluno : todosAlunos) {
            if (aluno.temDireitoRecuperacao()) {
                try {
                    alunosRecuperacao.adicionarAluno(aluno);
                    System.out.println("✓ " + aluno.getNome() + " adicionado à recuperação");
                } catch (IllegalArgumentException e) {
                    // Já estava na lista
                }
            }
        }
    }

    public List<Aluno> obterAlunosAprovadosDireto() {
        return todosAlunos.stream()
            .filter(Aluno::estaAprovadoDireto)
            .collect(Collectors.toList());
    }

    public AlunosEmRecuperacao obterAlunosRecuperacao() {
        return alunosRecuperacao;
    }

    public List<Aluno> obterTodosAlunos() {
        return new ArrayList<>(todosAlunos);
    }

    @Override
    public void gerar() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║      RELATÓRIO GERAL DO SISTEMA            ║");
        System.out.println("╚════════════════════════════════════════════╝");

        System.out.println("\n📊 ESTATÍSTICAS GERAIS:");
        System.out.println("  Total de Alunos: " + todosAlunos.size());
        System.out.println("  Aprovados Direto: " + obterAlunosAprovadosDireto().size());
        System.out.println("  Em Recuperação: " + alunosRecuperacao.obterTotal());

        System.out.println("\n" + alunosRecuperacao.obterResumo());

        System.out.println("\n╚════════════════════════════════════════════╝\n");
    }

    @Override
    public String obterResumo() {
        return String.format("Sistema com %d alunos | %d aprovados | %d em recuperação",
            todosAlunos.size(),
            obterAlunosAprovadosDireto().size(),
            alunosRecuperacao.obterTotal()
        );
    }
}