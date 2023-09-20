public class Disciplina {
    private String nome;
    private double nota;

    public Disciplina(String nome) {
        this.nome = nome;
        this.nota = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public void registrarNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
        } else {
            System.out.println("Nota inválida para a disciplina " + nome);
        }
    }
}
