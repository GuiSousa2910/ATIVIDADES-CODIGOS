public class Teste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", 5, Plano.OURO);

        System.out.println("Plano é: " + cliente.getPlano().getDescricao());

        for (Plano planoDaVez : Plano.values()) {
            System.out.println();
        }
    }
}
