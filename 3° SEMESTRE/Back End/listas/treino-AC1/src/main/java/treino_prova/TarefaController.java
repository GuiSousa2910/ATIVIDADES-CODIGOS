package school.sptech.treino_prova;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    TarefaRepository repository;

    @PostMapping
    public ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody Tarefa tarefa) {
        LocalDateTime hoje = LocalDateTime.now();
        if (tarefa.getPrazo().isBefore(hoje) || tarefa.getPrazo().isEqual(hoje)){
            return ResponseEntity.status(400).build();
        } else if (!repository.findByTituloContainingIgnoreCase(tarefa.getTitulo()).isEmpty()) {
            return ResponseEntity.status(409).build();
        }
        Tarefa tarefaNova = repository.save(tarefa);

        return ResponseEntity.status(201).body(tarefaNova);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> all = repository.findAll();
        if (all.isEmpty()){
            return ResponseEntity.status(204).body(all);
        }
            return ResponseEntity.status(200).body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Integer id) {
        Optional<Tarefa> possivelTarefa = repository.findById(id);

        if (possivelTarefa.isPresent()){
            return ResponseEntity.status(200).body(possivelTarefa.get());
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Integer id, @RequestBody Tarefa tarefa) {
        Optional<Tarefa> possivelTarefa = repository.findById(id);
        if (!possivelTarefa.isPresent()){
            return ResponseEntity.status(404).build();
        }

        if (tarefa.getStatus().equals("ATRASADA") || tarefa.getStatus().equals("FINALIZADA")){
            return ResponseEntity.status(400).build();
        }

        Tarefa tarefaOriginal = possivelTarefa.get();
        if (!tarefaOriginal.getTitulo().equalsIgnoreCase(tarefa.getTitulo()) && repository.existsByTituloIgnoreCase(tarefa.getTitulo())) {
            return ResponseEntity.status(409).build();
        }
        tarefa.setId(id);
        Tarefa tarefaAlterada = repository.save(tarefa);
        return ResponseEntity.status(200).body(tarefaAlterada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();

    }

    @GetMapping("/atrasadas")
    public ResponseEntity<List<Tarefa>> listarTarefasAtrasadas() {
        List<Tarefa> tarefasAtrasadas = new ArrayList<>();

        for (Tarefa t : repository.findAll()) {
            if (t.getStatus().equals("ATRASADA")) {
                tarefasAtrasadas.add(t);
            }
        }
        if (tarefasAtrasadas.isEmpty()){
            return ResponseEntity.status(204).body(tarefasAtrasadas);
        }else{
            return ResponseEntity.status(200).body(tarefasAtrasadas);
        }
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<Tarefa>> listarTarefasPorPeriodo(
            @RequestParam LocalDateTime inicio,
            @RequestParam LocalDateTime fim
    ) {
        List<Tarefa> tarefasEntrePeriodo = repository.findByPrazoBetween(inicio, fim);

        if (tarefasEntrePeriodo.isEmpty()){
            return ResponseEntity.status(204).body(tarefasEntrePeriodo);
        }
        return ResponseEntity.status(200).body(tarefasEntrePeriodo);
    }
}
