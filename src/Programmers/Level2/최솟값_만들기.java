package Programmers.Level2;

public class 최솟값_만들기 {
    public static void main(String[] args) {
        System.out.println(new Solution최솟값_만들기().solution2(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }
}


class Solution최솟값_만들기 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        for (int i = 0; i < B.length - 1; i++) {
            for (int j = 0; j < B.length - 1 - i; j++) {
                if (B[j] < B[j + 1]) {
                    int temp = B[j];
                    B[j] = B[j + 1];
                    B[j + 1] = temp;
                }
                if (A[j] < A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }
        return answer;
    }

    // ChatGPT
    public static int solution2(int[] A, int[] B) {
        int answer = 0;

        // Step 1: Sort A in ascending order
        quickSort(A, 0, A.length - 1, true);

        // Step 2: Sort B in descending order
        quickSort(B, 0, B.length - 1, false);

        // Step 3: Calculate the answer
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }

        return answer;
    }

    // QuickSort implementation
    public static void quickSort(int[] arr, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partition(arr, low, high, ascending);

            quickSort(arr, low, pi - 1, ascending);  // Recursively sort left part
            quickSort(arr, pi + 1, high, ascending); // Recursively sort right part
        }
    }

    // Partition method for quicksort
    public static int partition(int[] arr, int low, int high, boolean ascending) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // Compare based on ascending/descending order
            if (ascending ? arr[j] <= pivot : arr[j] >= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}