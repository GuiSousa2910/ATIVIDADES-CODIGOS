package school.sptech.aula_10._2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    public FilmeController(){
        filmes.add(new Filme("Shrek", "Aderal"));
        filmes.add(new Filme("O Poderoso Chefão", "Francis Ford Coppola"));
        filmes.add(new Filme("O Senhor dos Anéis", "Peter Jackson"));
        filmes.add(new Filme("teste", "Peter Jackson"));
    }

    @GetMapping("/filme")
    public Filme getFilme(){
        Filme filme = new Filme("Matrix", "Wachowski");
        return filme;
    }

    @GetMapping("/listar")
    public List<Filme> listar(){
        return filmes;
    }

    @GetMapping("/{nomeFilme}")
    public String buscarFilme(@PathVariable String nomeFilme){
        for(Filme filme: filmes){
            if (filme.getNome().equalsIgnoreCase(nomeFilme)){
                return "tem!";
            }
        }
        return "nao tem";
    }

}
