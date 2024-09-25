import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nome;
    private Integer qntPremios;
    private List<Musica> musicas;

    public Album(String nome, Integer qntPremios) {
        this.nome = nome;
        this.qntPremios = qntPremios;
        this.musicas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Album{" +
                "nome='" + nome + '\'' +
                ", qntPremios=" + qntPremios +
                ", musicas=" + musicas +
                '}';
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void exibirMusicaPorQntLikes(Integer filtro) {
        for (int i = 0; i < musicas.size(); i++) {
            Musica musicaDaVez = musicas.get(i);
            if (musicaDaVez.getQntLikes() >= filtro) {
                System.out.println("MUSICA DA VEZ \n" + musicaDaVez);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQntPremios() {
        return qntPremios;
    }

    public void setQntPremios(Integer qntPremios) {
        this.qntPremios = qntPremios;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

}