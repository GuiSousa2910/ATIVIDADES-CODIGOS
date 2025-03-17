package school.sptech.aula_17_03.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.aula_17_03.entity.Produto;
import school.sptech.aula_17_03.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produtos = service.listar();
        if (produtos.isEmpty()){
            return ResponseEntity.status(204).build();
        }

            return ResponseEntity.status(200).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarId(@PathVariable Integer id){
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.status(200).body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody Produto produto){
        Produto produtoRegistrado = service.cadastrar(produto);
        return ResponseEntity.status(201).body(produtoRegistrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.status(204).build();
    }
}
