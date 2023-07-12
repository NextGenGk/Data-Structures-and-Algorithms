package Arrays;

public class Stock_Buy_and_Sell {


    // Method 1: Brute Force
    // Time - O(N^2), Space - O(1)
    static int maximize (int[] arr, int n) {
        int maxProfit = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[j] - arr[i] > maxProfit) {
                    maxProfit = arr[j] - arr[i];
                }
            }
        }
        return maxProfit;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 6, 3, 4};
        int n = arr.length;

        int res = maximize(arr, n);
        System.out.println(res);
    }
}

// Output:
// 5

// Algorithm: Brute Force
/*
1. Initialize maxProfit = 0
2. Run a loop from i = 0 to n-1
    a. Run a loop from j = i+1 to n-1
        i. If arr[j] - arr[i] > maxProfit, then update maxProfit
3. Return maxProfit
 */