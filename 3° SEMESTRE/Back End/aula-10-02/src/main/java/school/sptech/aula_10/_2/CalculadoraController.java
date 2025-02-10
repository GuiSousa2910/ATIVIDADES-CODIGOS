package school.sptech.aula_10._2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private int contador;

    @GetMapping("/somar/{n1}/{n2}")
    public Integer somar(@PathVariable Integer n1, @PathVariable Integer n2){
        return n1 + n2;
    }

    @GetMapping("/subtrair/{n1}/{n2}")
    public Integer subtrair(@PathVariable Integer n1, @PathVariable Integer n2){
        return n1 - n2;
    }

    @GetMapping("/contar")
    public Integer contador(){
        return ++contador;
    }

}
