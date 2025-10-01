package Algorithms;

public class MergeSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int[] buffer = new int[arr.length];
        mergeSort(arr, buffer, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] buffer, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, buffer, left, mid);
        mergeSort(arr, buffer, mid + 1, right);

        merge(arr, buffer, left, mid, right);
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                buffer[k++] = arr[i++];
            } else {
                buffer[k++] = arr[j++];
            }
        }

        while (i <= mid) buffer[k++] = arr[i++];
        while (j <= right) buffer[k++] = arr[j++];

        for (int t = left; t <= right; t++) {
            arr[t] = buffer[t];
        }
    }
}
