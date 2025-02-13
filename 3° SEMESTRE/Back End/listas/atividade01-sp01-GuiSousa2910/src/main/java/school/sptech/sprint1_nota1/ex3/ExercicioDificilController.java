package school.sptech.sprint1_nota1.ex3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioDificilController {

    @GetMapping("/ex-03/{n}")
    public ExercicioDificilResponse exercicioDificil(@PathVariable int n) {
        if (n <= 0) {
            return new ExercicioDificilResponse(0, 0);
        }

        int a = 0;
        int b = 1;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
            sum += next;
        }

        return new ExercicioDificilResponse(b, sum);
    }
}