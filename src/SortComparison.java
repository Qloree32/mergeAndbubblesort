public class SortComparison {

    // Bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Merge sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Method to test both of them
    public static void main(String[] args) {
        int[] array1 = {64, 25, 12, 22, 11};
        int[] array2 = array1.clone();

        // Timer for bubble sort
        long startBubble = System.nanoTime();
        bubbleSort(array1);
        long endBubble = System.nanoTime();
        long bubbleSortTime = endBubble - startBubble;
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ns");

        // Timer for merge sort
        long startMerge = System.nanoTime();
        mergeSort(array2, 0, array2.length - 1);
        long endMerge = System.nanoTime();
        long mergeSortTime = endMerge - startMerge;
        System.out.println("Merge Sort Time: " + mergeSortTime + " ns");

        System.out.println("Sorted Array (Bubble Sort): ");
        printArray(array1);

        System.out.println("Sorted Array (Merge Sort): ");
        printArray(array2);
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
