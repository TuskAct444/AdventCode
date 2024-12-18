package binarysearch;

import java.util.Arrays;

public class SortingComparison {

    public static void main(String[] args) {
        // Size of the array
        int size = 100;
        int[] data = new int[size];

        // Fill the array with random values
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 23423523);
        }

        // Print the unsorted array (optional)
        System.out.println("Unsorted data: " + Arrays.toString(data));

        // Measure and print the runtime for each sorting algorithm
        long start, end;

        // Insertion Sort
        int[] dataForInsertion = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        insertionSort(dataForInsertion);
        end = System.nanoTime();
        System.out.println("Insertion Sort time: " + (end - start) + " ns");

        // Selection Sort
        int[] dataForSelection = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        selectionSort(dataForSelection);
        end = System.nanoTime();
        System.out.println("Selection Sort time: " + (end - start) + " ns");

        // Merge Sort
        int[] dataForMerge = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        mergeSort(dataForMerge);
        end = System.nanoTime();
        System.out.println("Merge Sort time: " + (end - start) + " ns");

        // Print sorted arrays (optional)
        System.out.println("Insertion Sort result: " + Arrays.toString(dataForInsertion));
        System.out.println("Selection Sort result: " + Arrays.toString(dataForSelection));
        System.out.println("Merge Sort result: " + Arrays.toString(dataForMerge));
    }

    // Insertion Sort
    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] data) {
        if (data.length < 2) {
            return;
        }

        int mid = data.length / 2;
        int[] left = Arrays.copyOfRange(data, 0, mid);
        int[] right = Arrays.copyOfRange(data, mid, data.length);

        mergeSort(left);
        mergeSort(right);

        merge(data, left, right);
    }

    private static void merge(int[] data, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }

        while (i < left.length) {
            data[k++] = left[i++];
        }

        while (j < right.length) {
            data[k++] = right[j++];
        }
    }
}
