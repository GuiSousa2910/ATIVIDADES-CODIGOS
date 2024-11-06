public class Moto extends Veiculo{
    private Boolean possuiCapacete;

    public Moto(String nomeCliente, String marca, Integer anoFabricacao, Boolean possuiCapacete) {
        super(nomeCliente, marca, anoFabricacao);
        this.possuiCapacete = possuiCapacete;
    }

    public Boolean getPossuiCapacete() {
        return possuiCapacete;
    }

    public void setPossuiCapacete(Boolean possuiCapacete) {
        this.possuiCapacete = possuiCapacete;
    }

    @Override
    public void exibirRelatorio(){
        System.out.println("Relatorio da moto de: " + nomeCliente);
        if (possuiCapacete) {
            System.out.println("Capacete OK");
        }else{
            System.out.println("Compra um capacete");
        }
    }
}
