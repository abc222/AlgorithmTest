package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int i, j, t, temp;
        temp = arr[start];
        i = start;
        j = end;
        while (i != j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[start] = arr[i];
        arr[i] = temp;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
