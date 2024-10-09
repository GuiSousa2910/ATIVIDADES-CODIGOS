package school.sptech;

public class VendedorComissao {
    private String nome;
    private Double vendas;
    private Double taxa;
    private Integer codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getVendas() {
        return vendas;
    }

    public void setVendas(Double vendas) {
        this.vendas = vendas;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public VendedorComissao() {

    }

    public Double calcularSalario() {
        return vendas * taxa;
    }

}
