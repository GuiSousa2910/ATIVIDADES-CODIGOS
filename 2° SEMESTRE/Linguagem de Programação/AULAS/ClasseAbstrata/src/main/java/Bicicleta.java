public class Bicicleta extends Veiculo{
    private Double calibragemPneus;

    public Bicicleta(String nomeCliente, String marca, Integer anoFabricacao, Double calibragemPneus) {
        super(nomeCliente, marca, anoFabricacao);
        this.calibragemPneus = calibragemPneus;
    }

    @Override
    public void exibirRelatorio(){
        System.out.println("Relatorio da bicicleta de: " + super.nomeCliente);
        if (calibragemPneus < 0.2){
            System.out.println("Calibragem dos pneus baixa");
        }else {
            System.out.println("Calibragem dos pneus OK");
        }
    }
}
