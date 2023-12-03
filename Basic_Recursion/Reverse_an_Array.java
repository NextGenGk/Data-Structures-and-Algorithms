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

// Algorithm
/*
1. Inputs: The function takes in an array arr, along with two indices i and j that denote the range of elements
to be reversed. The initial call would typically pass i as 0 (start of the array) and j as the last index of the array.

2. Base Case: The base case occurs when i is greater than or equal to j. This indicates that the entire array
or the designated range has been reversed, so the function simply returns.

3. Swapping Elements: Inside the function, it swaps the elements at indices i and j in the array using the
swap function. After the swap, it recurses by calling reverse with i+1 (moving towards the end) and n-1
(moving towards the start), attempting to reverse the rest of the array.
 */

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)