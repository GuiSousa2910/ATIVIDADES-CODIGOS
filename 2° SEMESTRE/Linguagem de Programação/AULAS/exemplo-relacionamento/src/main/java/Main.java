public class Main {
    public static void main(String[] args) {
        Musica musica1 = new Musica("Billie Jean", "Michael Jackson", 4.5);
        Musica musica2 = new Musica("Exagerado", "Cazuza", 3.5);

        musica1.curtir();
        musica2.curtir(6);

        Album album1 = new Album("Hit's 90", 10);
        album1.adicionarMusica(musica1);

        Album album2 = new Album("Favoritos", 10);
        album2.adicionarMusica(musica1);
        album2.adicionarMusica(musica2);

        System.out.println(album1);
        System.out.println(album2);

        musica2.listarMusica(musica2);
        System.out.println(musica2);

        album2.exibirMusicaPorQntLikes(2);

    }
}
