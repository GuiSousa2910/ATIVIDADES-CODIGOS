package school.sptech;

import java.util.List;

public class Main {

  public static void main(String[] args) {
      GerenciadorDeNotas gerenciador = new GerenciadorDeNotas();

      System.out.println(gerenciador.verificarResultado(gerenciador.calcularMedia(gerenciador.lerNotas())));

  }
}