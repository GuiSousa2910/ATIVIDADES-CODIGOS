package school.sptech.factory;

import school.sptech.Alimento;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AlimentoFactory {

    static Map<String, Field> campos() throws ReflectiveOperationException {
        Class<Alimento> clazz = Alimento.class;
        Class<?> superClazz = clazz.getSuperclass();

        Map<String, Field> mapCampos = new HashMap<>();
        String[] nomeCamposSuper = { "nome", "precoUnitario", "peso", "quantidadeDisponivel" };
        String[] nomeCampos = { "prazoValidade" };

        for (String campoNome : nomeCamposSuper) {
            Field campo = superClazz.getDeclaredField(campoNome);
            campo.trySetAccessible();

            mapCampos.put(campoNome, campo);
        }

        for (String campoNome : nomeCampos) {
            Field campo = clazz.getDeclaredField(campoNome);
            campo.trySetAccessible();

            mapCampos.put(campoNome, campo);
        }

        return mapCampos;
    }

    public static Object build(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, LocalDate prazoValidade) throws ReflectiveOperationException {
        Object obj = new Alimento();
        campos().get("nome").set(obj, nome);
        campos().get("precoUnitario").set(obj, precoUnitario);
        campos().get("peso").set(obj, peso);
        campos().get("quantidadeDisponivel").set(obj, quantidadeDisponivel);
        campos().get("prazoValidade").set(obj, prazoValidade);

        return obj;
    }
}
