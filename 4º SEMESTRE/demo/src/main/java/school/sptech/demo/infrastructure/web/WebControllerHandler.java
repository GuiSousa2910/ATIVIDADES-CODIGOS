package school.sptech.demo.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import school.sptech.demo.core.application.exception.DuplicidadeException;

import java.util.Map;

@RestControllerAdvice
public class WebControllerHandler {

    @ExceptionHandler(DuplicidadeException.class)
    public ResponseEntity<Map<String, String>> duplicidadeHandler(DuplicidadeException e){
        Map<String, String> detalhesErro = Map.of(
                "error:", "Ocorreu o seguinte erro: " + e.getMessage()
        );

        return ResponseEntity.status(409).body(detalhesErro);
    }

}
