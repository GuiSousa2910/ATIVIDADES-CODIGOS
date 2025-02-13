package school.sptech.sprint1_nota1.ex1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioFacilController {

    @GetMapping("/ex-01/{palavra}")
    public Boolean exercicioFacil(@PathVariable String palavra) {
        palavra = palavra.toLowerCase();

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == palavra.charAt((palavra.length() -1))) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
