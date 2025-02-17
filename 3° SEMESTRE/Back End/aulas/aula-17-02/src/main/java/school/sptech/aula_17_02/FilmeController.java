package school.sptech.aula_17_02;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    @PostMapping
    public Filme cadastrar(@RequestBody Filme novoFilme){


        filmes.add(novoFilme);
        return novoFilme;

    }

    @GetMapping("/listar")
    public List<Filme> listar(){
        return filmes;
    }

    @GetMapping ("/{index}")
    public Filme buscar(@PathVariable Integer id){
        if (id >= 0 && id < filmes.size()){
            return filmes.get(id);
        }else {
            return null;
        }
    }

    @PutMapping ("/{index}")
    public Filme atualizar (@RequestBody Filme filmeParaAtualizar, @PathVariable int id){

        filmes.set(id, filmeParaAtualizar);
        return filmeParaAtualizar;
    }

    @GetMapping ("/deletar/{indice}")
    public String deletar(@PathVariable int index){
        filmes.remove(index);

        return "Filme removido com sucesso";
    }



}

