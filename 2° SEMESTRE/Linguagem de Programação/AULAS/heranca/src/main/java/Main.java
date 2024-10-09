public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João", "123456", 3.0, 8.0, 2);
        Aluno aluno2 = new Aluno("Maria", "654321", 9.0, 7.0, 6);

        AlunoPos aluno3 = new AlunoPos("Guilherme", "123654", 4.8, 10.0, 1, 9.0, 5.0);

        Faculdade faculdade = new Faculdade("SPtech");

        faculdade.matricular(aluno1);
        faculdade.matricular(aluno2);
        faculdade.matricular(aluno3);

        aluno2.calcularMedia();
        aluno3.calcularMedia();
    }
}
