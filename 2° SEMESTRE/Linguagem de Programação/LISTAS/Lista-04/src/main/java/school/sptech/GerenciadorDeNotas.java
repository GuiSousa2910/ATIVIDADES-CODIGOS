package school.sptech;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeNotas {

    List<Double> lerNotas(){
        List<Double> listaNotas = new ArrayList<>();
        Scanner qntNotas = new Scanner(System.in);

        System.out.println("Quantas notas vai inserir: ");
        Double notas = qntNotas.nextDouble();

        if (notas < 1) {
            return listaNotas;
        }

        for (int i = 0; i < notas; i++) {
            System.out.println("Insira a "+(i + 1) +"° nota: ");
            Double nota = qntNotas.nextDouble();

            listaNotas.add(nota);
        }
            return listaNotas;
    }

    Double calcularMedia(List<Double> notas){
        Double soma = 0.0;

        if (notas == null || notas.isEmpty() == true){
            return null;
        }

            for (int i = 0; i < notas.size(); i++) {
                soma += notas.get(i);
            }

            Double media = soma / notas.size();

            return media;
    }

    Boolean verificarResultado(Double media){
        if (media == null || media < 0){
            return null;
        }else {
            if (media >= 7.0){
                return true;
            }
            else {
                return false;
            }
        }

    }
}

