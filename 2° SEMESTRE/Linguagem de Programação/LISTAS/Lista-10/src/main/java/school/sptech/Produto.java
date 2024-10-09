package school.sptech;

import java.time.LocalDate;

public class Produto {

    private String nome;
    private Double precoUnitario;
    private Integer quantidadeDisponivel;
    private Double peso;

    public Produto() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double calcularImposto() {
        return precoUnitario * 0.05;
    }

    public Boolean disponivelParaCompra(LocalDate dataAtual) {
        if (quantidadeDisponivel > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void comprar(Integer unidades) {
        if (unidades > 0) {
            if (quantidadeDisponivel >= unidades) {
                quantidadeDisponivel -= unidades;
            } else {
                System.out.println("Quantidade indisponível");
            }
        }
    }

    public void aumentarEstoque(Integer unidades){
        if (unidades > 0) {
            quantidadeDisponivel += unidades;
        }
    }




}
