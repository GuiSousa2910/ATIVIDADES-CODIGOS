
public class ContadorVariado {
    public static void main(String[] args) {
        for(Double contadorVariado = 0.15; contadorVariado < 5; contadorVariado += 0.15){
            System.out.println("%.2f".formatted(contadorVariado));
        }
    }
}
