package school.sptech.factory;

import school.sptech.Avaliacao;
import school.sptech.Livro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroFactory {

    static Map<String, Field> campos() throws ReflectiveOperationException {
        Class<Livro> clazz = Livro.class;

        Map<String, Field> mapCampos = new HashMap<>();
        String[] nomeCampos = { "titulo", "autor", "dataPublicacao", "avaliacoes" };

        for (String campoNome : nomeCampos) {
            Field campo = clazz.getDeclaredField(campoNome);
            campo.trySetAccessible();

            mapCampos.put(campoNome, campo);
        }

        return mapCampos;
    }

    public static Object build(String titulo, String autor, LocalDate dataPublicacao, List<Object> avaliacoes) throws ReflectiveOperationException {
        Class<Livro> livroClass = Livro.class;
        Constructor<?> constructor = livroClass.getDeclaredConstructors()[0];
        Object[] parameters = Arrays.stream(constructor.getParameters()).map(param -> null).toArray();

        Object obj = constructor.newInstance(parameters);

        campos().get("titulo").set(obj, titulo);
        campos().get("autor").set(obj, autor);
        campos().get("dataPublicacao").set(obj, dataPublicacao);
        campos().get("avaliacoes").set(obj, avaliacoes);

        return obj;
    }

    public static Livro buildBook(String titulo, String autor, LocalDate dataPublicacao, List<Avaliacao> avaliacoes) throws ReflectiveOperationException {
        Class<Livro> livroClass = Livro.class;
        Constructor<?> constructor = livroClass.getDeclaredConstructors()[0];
        Object[] parameters = Arrays.stream(constructor.getParameters()).map(param -> null).toArray();

        Object obj = constructor.newInstance(parameters);

        campos().get("titulo").set(obj, titulo);
        campos().get("autor").set(obj, autor);
        campos().get("dataPublicacao").set(obj, dataPublicacao);
        campos().get("avaliacoes").set(obj, avaliacoes);

        return (Livro) obj;
    }
}