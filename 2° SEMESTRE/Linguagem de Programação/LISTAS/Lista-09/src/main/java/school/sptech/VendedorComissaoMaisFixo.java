package school.sptech;

public class VendedorComissaoMaisFixo extends VendedorComissao {

    private Double salarioFixo;

    public VendedorComissaoMaisFixo() {
    }

    public Double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(Double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    @Override
    public Double calcularSalario() {
        return (getVendas() * getTaxa()) +salarioFixo;
    }

}
