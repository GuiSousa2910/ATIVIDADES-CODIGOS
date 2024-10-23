package school.sptech.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import school.sptech.Avaliacao;

public class AvaliacaoFactory {

    static Map<String, Field> campos() throws ReflectiveOperationException {
        Class<Avaliacao> clazz = Avaliacao.class;

        Map<String, Field> mapCampos = new HashMap<>();
        String[] nomeCampos = { "descricao", "qtdEstrelas" };

        for (String campoNome : nomeCampos) {
            Field campo = clazz.getDeclaredField(campoNome);
            campo.trySetAccessible();

            mapCampos.put(campoNome, campo);
        }

        return mapCampos;
    }

    public static Object build(String descricao, Double qtdEstrelas) throws ReflectiveOperationException {
        Class<Avaliacao> avaliacaoClass = Avaliacao.class;

        Constructor<?> constructor = avaliacaoClass.getDeclaredConstructors()[0];
        Object[] parameters = Arrays.stream(constructor.getParameters()).map(param -> null).toArray();

        Object obj = constructor.newInstance(parameters);

        campos().get("descricao").set(obj, descricao);
        campos().get("qtdEstrelas").set(obj, qtdEstrelas);
        return obj;
    }
}