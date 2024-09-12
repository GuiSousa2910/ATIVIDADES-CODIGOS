package school.sptech.ex1;

public class TesteConfeitaria {

  public static void main(String[] args) {

    Bolo bolo = new Bolo();
    bolo.sabor = "Chocolate";
    bolo.valor = 15.0;
    bolo.aumentarEstoque(100);
    bolo.venderBolo(42);
    bolo.quantidadeDisponivel();
    bolo.totalVendido();

    System.out.println("---------------------------------------");

    Bolo bolo2 = new Bolo();
    bolo2.sabor = "Chocolate";
    bolo2.valor = 100.0;
    bolo2.aumentarEstoque(12);
    bolo2.venderBolo(1);
    bolo2.quantidadeDisponivel();
    bolo2.totalVendido();

  }
}
