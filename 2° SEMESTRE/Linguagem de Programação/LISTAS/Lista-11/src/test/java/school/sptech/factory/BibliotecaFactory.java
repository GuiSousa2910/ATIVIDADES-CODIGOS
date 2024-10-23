package school.sptech.factory;

import school.sptech.Biblioteca;
import school.sptech.Livro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaFactory {

    static Map<String, Field> campos() throws ReflectiveOperationException {
        Class<Biblioteca> clazz = Biblioteca.class;

        Map<String, Field> mapCampos = new HashMap<>();
        String[] nomeCampos = { "nome", "livros" };

        for (String campoNome : nomeCampos) {
            Field campo = clazz.getDeclaredField(campoNome);
            campo.trySetAccessible();

            mapCampos.put(campoNome, campo);
        }

        return mapCampos;
    }

    public static Object build(String titulo,List<Livro> livros) throws ReflectiveOperationException {
        Class<Biblioteca> bibliotecaClass = Biblioteca.class;

        Constructor<?> constructor = bibliotecaClass.getDeclaredConstructors()[0];
        Object[] parameters = Arrays.stream(constructor.getParameters()).map(param -> null).toArray();

        Object obj = constructor.newInstance(parameters);

        campos().get("nome").set(obj, titulo);
        campos().get("livros").set(obj, livros);
        return obj;
    }
}
