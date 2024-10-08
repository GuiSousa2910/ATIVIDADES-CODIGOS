package school.sptech.factory;

import school.sptech.Produto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ProdutoFactory {

    static Map<String, Field> campos() throws ReflectiveOperationException {
        Class<Produto> clazz = Produto.class;

        Map<String, Field> mapCampos = new HashMap<>();
        String[] nomeCampos = { "nome", "precoUnitario", "peso", "quantidadeDisponivel" };

        for (String campoNome : nomeCampos) {
            Field campo = clazz.getDeclaredField(campoNome);
            campo.trySetAccessible();

            mapCampos.put(campoNome, campo);
        }

        return mapCampos;
    }

    public static Object build(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel) throws ReflectiveOperationException {
        Object obj = new Produto();
        campos().get("nome").set(obj, nome);
        campos().get("precoUnitario").set(obj, precoUnitario);
        campos().get("peso").set(obj, peso);
        campos().get("quantidadeDisponivel").set(obj, quantidadeDisponivel);

        return obj;
    }
}
