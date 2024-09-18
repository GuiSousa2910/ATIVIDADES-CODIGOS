package bilheteunico;

public class Testes {

    public static void main(String[] args) {
        BilheteUnico b1 = new BilheteUnico();
        b1.qntVezesUsada = 0;
        b1.codigoBilhete = "B001";
        b1.saldo = 0.0;
        b1.nomeTitular = "Bob";

        System.out.println("-----------------");
        BilheteUnico b2 = new BilheteUnico();
        b2.qntVezesUsada = 0;
        b2.codigoBilhete = "B001";
        b2.saldo = 0.0;
        b2.nomeTitular = "Bob";

        b1.carregar(42.0);
        Boolean deuCerto = b2.usar();
    }
}
