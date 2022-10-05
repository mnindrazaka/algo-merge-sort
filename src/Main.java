public class Main {
    public static int[] merge(int[] array1, int[] array2) {
        int i = 0; int j = 0; int k = 0;

        int[] results = new int[array1.length + array2.length];

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                results[k++] = array1[i++];
            } else {
                results[k++] = array2[j++];
            }
        }

        for (; i < array1.length; i++) {
            results[k++] = array1[i];
        }

        for (; j < array2.length; j++) {
            results[k++] = array2[j];
        }

        return results;
    }

    public static int[] mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return new int[]{ array[low] };
        }

        int mid = (low + high) / 2;

        int[] array1 = mergeSort(array, low, mid);
        int[] array2 = mergeSort(array, mid + 1, high);
        return merge(array1, array2);
    }


    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        int[] array3 = mergeSort(array, 0, array.length - 1);

        for (int i : array3) {
            System.out.print(i + " ");
        }
    }
}