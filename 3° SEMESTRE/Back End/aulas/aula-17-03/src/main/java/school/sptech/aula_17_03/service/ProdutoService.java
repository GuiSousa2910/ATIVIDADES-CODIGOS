package school.sptech.aula_17_03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.aula_17_03.entity.Produto;
import school.sptech.aula_17_03.exception.EntidadeConflitoException;
import school.sptech.aula_17_03.exception.EntidadeNaoEncontradaException;
import school.sptech.aula_17_03.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listar() {
        return repository.findAll();
    }

     public Produto buscarPorId(Integer id){
//        Optional<Produto> produtoOpt = repository.findById(id);
//
//        if (produtoOpt.isPresent()){
//            return produtoOpt.get();
//        }
//        throw new EntidadeNaoEncontradaException("Produto do id: %d nao encontrada".formatted(id));
         return repository.findById(id).orElseThrow(
                 () -> new EntidadeNaoEncontradaException("Produto do id: %d nao encontrada".formatted(id))
         );
    }

    public Produto cadastrar(Produto produto){
        if (repository.existsByCodigoIgnoreCase(produto.getCodigo())){
            throw new EntidadeConflitoException("Produto com codigo ja cadsatrado");
        }
        return repository.save(produto);
    }

    public void deletar(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
        throw new EntidadeNaoEncontradaException("Produto nao encontrado");
    }
}