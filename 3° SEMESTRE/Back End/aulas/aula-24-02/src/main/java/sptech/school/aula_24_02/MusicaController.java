package sptech.school.aula_24_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaRepository repository;

    @PostMapping
    public ResponseEntity<Musica> cadastrar(@RequestBody Musica musica){
        Musica musicaRegistrada = repository.save(musica);
        return ResponseEntity.status(201).body(musicaRegistrada);
    }

    @GetMapping
    public ResponseEntity<List<Musica>> listar(){
        List<Musica> all = repository.findAll();

        if (all.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> listarId(@PathVariable Integer id){
        Optional<Musica> possivelMusica = repository.findById(id);

        if (possivelMusica.isPresent()){
            return ResponseEntity.status(200).body(possivelMusica.get());
        }
        return ResponseEntity.status(404).build();

        //return ResponseEntity.of(repository.finById(id))

    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@PathVariable Integer id, @RequestBody Musica musicaParaAlterar){
        Optional<Musica> possivelMusica = repository.findById(id);

        if (repository.existsById(id)){
            musicaParaAlterar.setId(id);
            Musica musicaAlterada = repository.save(musicaParaAlterar);
            return ResponseEntity.status(200).body(musicaAlterada);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
            return ResponseEntity.status(404).build();
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Musica>> buscarLetra(@PathVariable String titulo){

        List<Musica> lista = repository.findAll();
        List<Musica> listaNova = new ArrayList<>();

        titulo = titulo.toLowerCase();

        for(Musica musicaDaVez:lista){
            if (musicaDaVez.getTituloMusica().toLowerCase().contains(titulo)){
                listaNova.add(musicaDaVez);
            }
        }

        if (!listaNova.isEmpty()){
            return ResponseEntity.status(200).body(listaNova);
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping("/mais-recente")
    public ResponseEntity<Musica> listarRecente() {
        Musica musica = repository.findTop1ByOrderByDataLancamentoDesc();
        return ResponseEntity.status(200).body(musica);
    }

    @GetMapping("/antes?data={data}")
    public ResponseEntity<List<Musica>> listarRecenteURL(@PathVariable LocalDate data) {
       Musica musica = repository.findByDataLancamentoLessThan(data);
       List<Musica> datasAntes = new ArrayList<>();

       datasAntes.add(musica);
       return ResponseEntity.status(200).body(datasAntes);
    }
}
