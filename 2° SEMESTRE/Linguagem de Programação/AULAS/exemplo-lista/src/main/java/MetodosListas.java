import java.util.List;

public class MetodosListas {
    void exibeListaDeNomes(List<String> lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}
