// Java
package school.sptech.exemplo_strategy.controller.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;

public class FreteRequestDto {

    @NotNull
    @DecimalMin(value = "1.0")
    private Double pesoEmKg;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoFreteEnum tipo;

    @NotNull
    @DecimalMin(value = "10.0")
    private Double valorEncomenda;

    public FreteRequestDto() {
    }

    public FreteRequestDto(Double pesoEmKg, TipoFreteEnum tipo, Double valorEncomenda) {
        this.pesoEmKg = pesoEmKg;
        this.tipo = tipo;
        this.valorEncomenda = valorEncomenda;
    }

    public static Frete toEntity(FreteRequestDto dto){
        Frete frete = new Frete();
        frete.setPesoEmKg(dto.getPesoEmKg());
        frete.setTipo(dto.getTipo());
        frete.setValorEncomenda(dto.getValorEncomenda());
        return frete;
    }

    public Double getPesoEmKg() {
        return pesoEmKg;
    }

    public void setPesoEmKg(Double pesoEmKg) {
        this.pesoEmKg = pesoEmKg;
    }

    public TipoFreteEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoFreteEnum tipo) {
        this.tipo = tipo;
    }

    public Double getValorEncomenda() {
        return valorEncomenda;
    }

    public void setValorEncomenda(Double valorEncomenda) {
        this.valorEncomenda = valorEncomenda;
    }
}