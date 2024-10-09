package school.sptech.factory;

import school.sptech.Eletronico;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class EletronicoFactory {

    static Map<String, Field> campos() throws ReflectiveOperationException {
        Class<Eletronico> clazz = Eletronico.class;
        Class<?> superClazz = clazz.getSuperclass();

        Map<String, Field> mapCampos = new HashMap<>();
        String[] nomeCamposSuper = { "nome", "precoUnitario", "peso", "quantidadeDisponivel" };
        String[] nomeCampos = { "dataFabricacao", "nacional" };

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

    public static Object build(String nome, Double precoUnitario, Double peso, Integer quantidadeDisponivel, LocalDate dataFabricacao, Boolean nacional) throws ReflectiveOperationException {
        Object obj = new Eletronico();
        campos().get("nome").set(obj, nome);
        campos().get("precoUnitario").set(obj, precoUnitario);
        campos().get("peso").set(obj, peso);
        campos().get("quantidadeDisponivel").set(obj, quantidadeDisponivel);
        campos().get("dataFabricacao").set(obj, dataFabricacao);
        campos().get("nacional").set(obj, nacional);

        return obj;
    }
}
