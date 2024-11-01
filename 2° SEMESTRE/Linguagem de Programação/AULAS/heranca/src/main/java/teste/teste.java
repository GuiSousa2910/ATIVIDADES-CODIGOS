package teste;

import agregacao.Faculdade;
import heranca.Aluno;
import heranca.AlunoPos;

public class teste {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João", "123456", 3.0, 8.0, 2);
        Aluno aluno2 =  new AlunoPos("Guilherme", "123654", 4.8, 10.0, 1, 9.0, 5.0);
        Faculdade faculdade01 = new Faculdade("SPtech");

        faculdade01.matricular(aluno1);
        faculdade01.matricular(aluno2);

        faculdade01.exibirAlunosPos();
    }
}
