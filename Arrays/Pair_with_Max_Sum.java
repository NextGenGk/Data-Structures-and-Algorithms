package Arrays;

public class Pair_with_Max_Sum {

    // Method 1 - Better Solution
    // Time - O(N), Space - O(1)
    public static long pairWithMaxSum(long[] arr, long N)
    {
        long curSum = 0;
        long maxSum = 0;

        for(int i=0; i<N-1; i++) {
            curSum = arr[i] + arr[i+1];

            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }

    // Main Function
    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5};
        long N = arr.length;
        System.out.println(pairWithMaxSum(arr, N));
    }
}

// Algorithm:
/*
    1. Initialize curSum = 0, maxSum = 0
    2. Iterate over the array from 0 to N-1
        2.1 curSum = arr[i] + arr[i+1]
        2.2 maxSum = max(curSum, maxSum)
    3. Return maxSum
 */