package Sorting;

public class BubbleSort_Optimize {

    // Bubble Sort Function
    public static void bubbleSort(int[] arr) {
        boolean swapped = false;
        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false) {
                break;
            }
        }
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
        bubbleSort(arr);
        printArray(arr);
    }
}


// Algorithms (Approach) ->
/*
Optimized approach (Reducing time complexity for the best case):

The best case occurs if the given array is already sorted. We can reduce the time complexity to O(N)
 by just adding a small check inside the loops.

1. We will check in the first iteration if any swap is taking place. If the array is already sorted
 no swap will occur and we will break out from the loops.
2. Thus the iteration of the outer loop will be just 1. And our overall time complexity will be O(N).
 */

/* Time & Space Complexity
    Worst complexity: O(n^2)
    Average complexity: O(n^2)
    Best complexity: O(n)
    Space complexity: O(1)
 */

// Anuj Bhaiya - https://www.youtube.com/watch?v=bBQkErahU9c