package Basic_Recursion;

public class Reverse_an_Array {

    // Swap Function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Reverse Array Function
    static void reverse(int[] arr, int i, int j) {
        int n = arr.length-1;
        if (i >= j) {
            return;
        }
        swap(arr, i, j);
        reverse(arr, i+1, n-1);
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        reverse(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)