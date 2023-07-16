package Arrays;

import java.util.HashMap;

public class Count_Subarray_with_Given_Sum {

    // Method 1 - Brute Force (Using 3 for Loops)
    // Time - O(N^3), Space - O(1)
//    static int subarrayCounts(int[] arr, int n, int K) {
//        int count = 0;
//        for (int i=0; i<n; i++) {
//            for (int j=i; j<n; j++) {
//                int sum = 0;
//                for (int k=i; k<=j; k++) {
//                    sum += arr[k];
//                }
//                if (sum == K) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // Method 2 - Brute Force (Using 2 for Loops)
    // Time - O(N^2), Space - O(1)
//    static int subarrayCounts(int[] arr, int n, int K) {
//        int count = 0;
//        for (int i=0; i<n; i++) {
//            int sum = 0;
//            for (int j=i; j<n; j++) {
//                sum += arr[j];
//
//                if (sum == K) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // Method 3 - Better Solution (Using HashMap)
    // Time - O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
    // Space - O(N) because using Map Data Structure
    static int subarrayCounts(int[] arr,int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int preSum = 0;
        int count = 0;

        map.put(0, 1);

        for (int i=0; i<n; i++) {
            preSum += arr[i];

            if (map.containsKey(preSum-k)) {
                count += map.get(preSum-k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3}; // {3, -3, 1, 1, 1} -> (0, 1)
        int n = arr.length;

        int K = 3;

        int result = subarrayCounts(arr, n, K);
        System.out.println(result);
    }
}

// Output:
// 6

// Algorithm: Brute Force (Using 3 for Loops)
/*
1. Initialize count = 0
2. Run a loop from i=0 to n-1
    2.1 Run a loop from j=i to n-1
        2.1.1 Initialize sum = 0
        2.1.2 Run a loop from k=i to j
3. If sum == K, then increment count
4. Return count
 */

// Algorithm: Better Solution (Using 2 for Loops)
/*
1. Initialize count = 0
2. Run a loop from i=0 to n-1
    2.1 Initialize sum = 0
    2.2 Run a loop from j=i to n-1
        2.2.1 Add arr[j] to sum
        2.2.2 If sum == K, then increment count
3. Return count
 */

// Algorithm: Optimal Solution (Using HashMap)
/*
1. Create a HashMap
2. Initialize preSum = 0, count = 0
3. Insert (0, 1) in the HashMap
4. Run a loop from i=0 to n-1
    4.1 Add arr[i] to preSum
    4.2 If (preSum - K) is present in the HashMap
        4.2.1 Increment count by the value of (preSum - K) in the HashMap
    4.3 Insert (preSum, preSum + 1) in the HashMap
5. Return count
 */