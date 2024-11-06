public class Teste {
    public static void main(String[] args) {
        Carro carro1 = new Carro("João", "Fiat", 2010, 0.3, false);
        Bicicleta bicicleta1 = new Bicicleta("Maria", "Caloi", 2015, 0.1);
        Moto moto1 = new Moto("José", "Honda", 2018, false);

        carro1.exibirRelatorio();
        System.out.println("--------------------");
        bicicleta1.exibirRelatorio();
        System.out.println("--------------------");
        moto1.exibirRelatorio();
    }
}
