package cofrinho;

public class TesteCofrinho {
    public static void main(String[] args) {
        Cofrinho cofrinho1 = new Cofrinho("Comprar PS5", false);
        cofrinho1.depositar(100.0);
        System.out.println("Saldo: " + cofrinho1.getRetorneSaldo());
        cofrinho1.agitar();
        cofrinho1.quebrar();

        System.out.println("-----------------");

//      Cofrinho cofrinho2 = new Cofrinho();
//      cofrinho2.meta = "Comprar PS3";
//      cofrinho2.depositar(150.0);
//      cofrinho2.agitar();
        Cofrinho cofrinho2 = new Cofrinho(true);
        cofrinho2.depositar(150.0, 30.0);
        System.out.println("Saldo: " + cofrinho2.getSaldo());
        cofrinho2.agitar();

        System.out.println("-----------------");

        Cofrinho cofrinho3 = new Cofrinho(false);
        cofrinho3.depositar(190.0, 30.0);
        System.out.println("Saldo: " + cofrinho3.getSaldo());
        cofrinho3.setMeta("Comprar PC Gamer");
        cofrinho3.agitar();
    }
}