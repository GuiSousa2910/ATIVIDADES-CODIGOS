package school.sptech;

public class SelectionSort {

    public void selectionSort(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[i]) {
                    int temp = v[i]; v[i] = v[j]; v[j] = temp;
                }
            }
        }
    }
}
