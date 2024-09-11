public class Testes {

    public static void main(String[] args) {
        BilheteUnico b1 = new BilheteUnico();
        b1.qntVezesUsada = 0;
        b1.codigoBilhete = "B001";
        b1.saldo = 0.0;
        b1.nomeTitular = "Bob";

        BilheteUnico b2 = new BilheteUnico();
        b2.qntVezesUsada = 0;
        b2.codigoBilhete = "B001";
        b2.saldo = 0.0;
        b2.nomeTitular = "Bob";

        b1.carregar(42.0);
        Boolean deuCerto = b2.usar();

        Cofrinho cofrinho1 = new Cofrinho();

        cofrinho1.meta = "Comprar PS5";
        cofrinho1.quebrar();
        cofrinho1.depositar(100.0);
        cofrinho1.agitar();

        Cofrinho cofrinho2 = new Cofrinho();
        cofrinho2.meta = "Comprar PS3";
        cofrinho2.depositar(150.0);
        cofrinho2.agitar();

    }

}
