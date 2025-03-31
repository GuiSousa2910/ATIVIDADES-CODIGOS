package school.sptech.exemplo_strategy.service;

import org.springframework.stereotype.Service;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.repository.FreteRepository;

import java.util.List;

@Service
public class FreteService {

    private final FreteRepository freteRepository;

    public FreteService(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    public Frete registrarCotacao(Frete frete) {
        frete.setValorFrete(frete.getTipo().getValorFixo() + (frete.getTipo().getAcrescimo() * frete.getPesoEmKg()));
        Frete novoPedido = freteRepository.save(frete);
        return novoPedido;
    }

    public List<Frete> listarCotacoes() {
        return freteRepository.findAll();
    }
}
