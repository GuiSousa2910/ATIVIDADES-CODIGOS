package school.sptech.ex_carro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    CarroRepository repository;

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro){
        carro.setId(null);
        if (repository.existsByPlaca(carro.getPlaca())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Carro carroNovo = repository.save(carro);
            return ResponseEntity.status(201).body(carroNovo);
        }
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> all = repository.findAll();
        if (all.isEmpty()){
        return ResponseEntity.status(204).body(all);
        }
        return ResponseEntity.status(200).body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> listarCarroId(@PathVariable Integer id){
        Optional<Carro> acharCarro = repository.findById(id);
        if (acharCarro.isPresent()){
            return ResponseEntity.status(200).body(acharCarro.get());
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> attCarroId(@PathVariable Integer id, @RequestBody Carro carro){
        if (repository.existsById(id)){
            carro.setId(id);
            Carro carroNovo = repository.save(carro);
            return ResponseEntity.status(200).body(carroNovo);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
            return ResponseEntity.status(404).build();
    }

    @GetMapping("/marca")
    public ResponseEntity<List<Carro>> listarPorMarca(@RequestParam String marca) {
        List<Carro> carrosDaMarca = repository.findByMarcaContainingIgnoreCase(marca);
        if (carrosDaMarca.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(carrosDaMarca);
    }
}
