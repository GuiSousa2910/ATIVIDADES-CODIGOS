public class Musica {
    private String nome;
    private String artista;
    private Double minutos;
    private Integer qntLikes;

    public Musica(String nome, String artista, Double minutos) {
        this.nome = nome;
        this.artista = artista;
        this.minutos = minutos;
        this.qntLikes = 0;
    }

    public void curtir() {
        qntLikes++;
    }

   public void curtir(Integer qntLikes) {
        this.qntLikes += qntLikes;
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Double getMinutos() {
        return minutos;
    }

    public void setMinutos(Double minutos) {
        this.minutos = minutos;
    }

    public Integer getQntLikes() {
        return qntLikes;
    }

    public void listarMusica(Musica musica){
        System.out.println("AQUI É O LISTAR MUSICA" + musica);
    }

    @Override
    public String toString() {
        return """
                Nome: %s
                Artista: %s
                Minutos: %.2f
                Likes: %d
                ------------------
                """.formatted(nome, artista, minutos, qntLikes);
    }
}