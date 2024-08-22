public class DesafioMetodos {
    Boolean palindromo(String frase, String fraseInversa){
        frase = frase.toLowerCase().replace(" ", "");
        fraseInversa = fraseInversa.toLowerCase().replace(" ", "");
        Integer tamanhoFrase = frase.length();
        if (tamanhoFrase.equals(fraseInversa.length())){
            for (int i = 0, j = fraseInversa.length() - 1; i < frase.length(); i++, j--) {
                String texto = String.valueOf(frase.charAt(i));
                String textoInverso = String.valueOf(fraseInversa.charAt(j));
                if (!texto.equals(textoInverso)){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }
}
