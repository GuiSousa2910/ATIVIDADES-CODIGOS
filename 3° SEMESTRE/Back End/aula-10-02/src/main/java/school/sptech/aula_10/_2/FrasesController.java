package school.sptech.aula_10._2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrasesController {

    @GetMapping("/frases/saudacao")
    public String saudacao(){
        return "Olá, Mundo!";
    }

    @GetMapping("/frases/ola/{nome}")
    public String saudacao(@PathVariable String nome){
        return "Olá %s".formatted(nome);
    }

}
