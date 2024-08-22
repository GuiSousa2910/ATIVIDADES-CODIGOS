public class MetodosUteis {

    void exibirUsuario(String nomeUsuario){
        System.out.println("""
               *----*----*
               O nome do usuario é: %s
               *----*----*""".formatted(nomeUsuario));
    }

    Double somar(Double n1, Double n2){
        Double soma = n1 + n2;
        return soma;
    }
}
