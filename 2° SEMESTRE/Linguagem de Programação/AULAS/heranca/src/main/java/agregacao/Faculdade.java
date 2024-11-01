package agregacao;

import heranca.Aluno;
import heranca.AlunoPos;

import java.util.ArrayList;
import java.util.List;

public class Faculdade {
    private String nome;
    private List<Aluno> alunos;

    public Faculdade(String nome) {
        this.nome = nome;
        alunos = new ArrayList<>();
    }

    public void matricular(Aluno aluno) {
        alunos.add(aluno);
    }

    public Double somaNotasEntregas() {
        Double totalNE = 0.0;
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aV = alunos.get(i);
            totalNE += aV.getNotaEntrega();
        }
        System.out.println("Soma das notas: " + totalNE);
        return totalNE;
    }

    public List<Aluno> buscaAlunoPorNome(String nome) {
        List<Aluno> alunosFiltrados = new ArrayList<>();

        for (Aluno alunoDaVez : alunos) {
            if (alunoDaVez.getNome().equalsIgnoreCase(nome)) {
                alunosFiltrados.add(alunoDaVez);
            }
        }
        return alunosFiltrados;
    }

    public void deletarAluno() {
        alunos.clear();
    }

    public void exibirAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public void exibirAlunosPos() {
        for (Aluno aluno : alunos) {
            if (aluno instanceof AlunoPos) {
                System.out.println(aluno);
            }
        }
    }

    public void exibirAlunosNormal() {
        for (Aluno aluno : alunos) {
            if (aluno instanceof Aluno) {
                System.out.println(aluno);
            }
        }
    }

    public Double somaNotasTCC() {
        Double soma = 0.0;

        for (Aluno aluno : alunos) {
            if (aluno instanceof AlunoPos) {
                soma += ((AlunoPos) aluno).getNotaTCC();
            }
        }
        return soma;
    }
}
