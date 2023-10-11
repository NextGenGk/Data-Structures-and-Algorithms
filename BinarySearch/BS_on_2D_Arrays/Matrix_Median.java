package BinarySearch.BS_on_2D_Arrays;

public class Matrix_Median {

    // Method 1 : Brute Force
    // Time : O(row*col log(row*col)) for sorting the array where r*c denotes the number of elements
    // in the linear array.
    // Space : O(row*col)  for storing elements in the linear array
    public static int findMedian(int[][] arr, int row, int col) {
        int[] median = new int[row * col];
        int index = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                median[index] = arr[i][j];
                index++;
            }
        }
        return median[(row * col) / 2];
    }

    // Main Function
    public static void main(String[] args) {
        int row = 3, col = 3;
        int[][] arr =
                {{1, 3, 8},
                {2, 3, 4},
                {1, 2, 5}};
        System.out.println("The median of the row-wise sorted matrix is: "+
                findMedian(arr, row, col));
    }
}

// Output :
// The median of the row-wise sorted matrix is: 3

// Algorithm : Brute Force
/*
1. It creates an integer array called median with a length of row * col to store all the elements of the 2D array.
2. It initializes an index variable to keep track of the current position in the median array.
3. It uses nested loops to iterate through each element of the 2D array (arr) and stores them in the median array,
   effectively flattening the 2D array into a 1D array.
4. Finally, it calculates and returns the element at the middle position in the median array as the median.
   The median of an array is typically the middle element if the array is sorted.

However, there are a few potential issues with this code:
Efficiency: This code creates a new array and copies all the elements from the 2D array into it. This can be
inefficient and consume extra memory if the input array is very large.

Median Calculation: The code assumes that the median is simply the middle element of the flattened array.
This is only true if the elements are sorted. If the elements are not sorted, this will not give the correct median value.

If you want to calculate the median of the elements in the 2D array correctly, you should sort the flattened array
and then find the middle element. You can use built-in sorting methods like Arrays.sort() to sort the array
before finding the median.
 */