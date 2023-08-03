package Sorting;

public class Recursive_BubbleSort_Optimize {

    public static void bubbleSort(int[] arr, int n) {

        // Base Case
        if(n == 1) return;

        // Optimize
        int didSwap = 0;

        for(int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                // Swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                didSwap = 1;
            }
        }
        // Optimize
        if (didSwap == 0) {
            return;
        }

        // Recursive Case
        bubbleSort(arr, n-1);
    }

    // Print Method (Print all the sorted element)
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {2,8,9,1,4};
        bubbleSort(arr, arr.length);
        printArray(arr);
    }
}

// In Bubble Sort - Push the maximum element to the last, using adjacent swaps

// Output:
// 1 2 4 8 9

// Time & Space Complexity
/*
Time Complexity: O(N2)
for the worst and average cases and O(N) for the best case. Here, N = size of the array.

Space Complexity: O(N) auxiliary stack space.
 */

// Striver - https://takeuforward.org/arrays/recursive-bubble-sort-algorithm/