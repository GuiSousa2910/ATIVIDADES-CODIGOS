public abstract class Veiculo {
    protected String nomeCliente;
    protected String marca;
    protected Integer anoFabricacao;

    public Veiculo(String nomeCliente, String marca, Integer anoFabricacao) {
        this.nomeCliente = nomeCliente;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
    }

    public abstract void exibirRelatorio();
}
