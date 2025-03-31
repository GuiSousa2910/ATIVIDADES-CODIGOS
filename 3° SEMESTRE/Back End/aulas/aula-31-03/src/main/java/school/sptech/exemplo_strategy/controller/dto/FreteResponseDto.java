// Java
package school.sptech.exemplo_strategy.controller.dto;

import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;

public class FreteResponseDto {
    private Integer id;
    private TipoFreteEnum tipo;
    private Double valorFrete;
    private String descricao;

    public FreteResponseDto() {
    }

    public FreteResponseDto(Integer id, TipoFreteEnum tipo, Double valorFrete, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.valorFrete = valorFrete;
        this.descricao = descricao;
    }

    public static FreteResponseDto toResponse(Frete frete) {
        FreteResponseDto dto = new FreteResponseDto();
        dto.setId(frete.getId());
        dto.setTipo(frete.getTipo());
        dto.setDescricao(frete.getTipo().getDescricao());
        dto.setValorFrete(frete.getValorFrete());
        return dto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoFreteEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoFreteEnum tipo) {
        this.tipo = tipo;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}