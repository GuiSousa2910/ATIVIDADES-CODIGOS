package school.sptech;

public class SelectionSortOtimizado {

    public void selectionSortOtimizado(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            int indMenor = i; for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[indMenor]) { indMenor = j;
                }
            }
            int temp = v[i];
            v[i] = v[indMenor]; v[indMenor] = temp;
        }
    }
}
