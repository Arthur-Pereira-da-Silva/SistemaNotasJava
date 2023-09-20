import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int matricula;
    private ArrayList<Disciplina> disciplinas;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void exibirBoletim() {
        System.out.println("Boletim de " + nome + " (Matrícula: " + matricula + ")");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.getNome() + ": " + disciplina.getNota());
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
