package school.sptech.aula_10._2;

public class Filme {

    private String nome;
    private String diretor;

    public Filme(String nome, String diretor){
        this.nome = nome;
        this.diretor = diretor;
    }

    public Filme(){}

    public String getCuriosidade(){
        return "Curiosidade";
    }

    public String getNome(){
        return nome;
    }
    public String getDiretor(){
        return diretor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
