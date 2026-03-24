public class Aluno implements Avaliavel, Recuperavel, Relatorio {
    private String nome;
    private int idade;
    private double nota;

    public Aluno(String nome, int idade, double nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    @Override
    public double calcularNota() {
        return nota;
    }

    @Override
    public boolean recuperar() {
        return nota < 6.0;
    }

    @Override
    public String gerarRelatorio() {
        return String.format("Nome: %s, Idade: %d, Nota: %.2f", nome, idade, nota);
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}