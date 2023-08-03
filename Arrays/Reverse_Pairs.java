package Arrays;

import java.util.ArrayList;

public class Reverse_Pairs {

    // Method 1 : Brute Force
    // Time Complexity: O(N^2), where N = the size of the given array.
    // Reason: We are using nested loops here and those two loops roughly run for N times.
    // Space Complexity: O(1) as we are not using any extra space to solve this problem.
//    public static int countPairs(int[] arr, int n) {
//
//        // Count the number of pairs:
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (arr[i] > 2 * arr[j])
//                    cnt++;
//            }
//        }
//        return cnt;
//    }
//

    // Method 2 : Optimal Solution (Using Merge Sort)
    //
    static int divide(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;

        int mid = low + (high - low)/2;
        count += divide(arr, low, mid);
        count += divide(arr, mid+1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    // Merge Function (same as Merge Sort)
    // Time Complexity: O(2N*logN), where N = size of the given array.
    // Reason: We are not changing the merge sort algorithm except by adding a variable to it.
    // So, the time complexity is as same as the merge sort.
    // Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Count Pairs Function
    static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid+1;
        int count = 0;
        for (int i=low; i<=mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
                count += (right - (mid + 1));
            }
        }
        return count;
    }

    // Inversion Function (Question)
    static int inversions(int[] arr, int n) {
        return divide(arr, 0, n-1);
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 1};
        int n = 5;
        int cnt = inversions(arr, n);
        System.out.println("The number of reverse pair is: " + cnt);
    }
}

// Output
// The number of reverse pair is: 3

// Algorithm : Brute Force
/*
1. First, we will run a loop(say i) from 0 to N-1 to select the a[i].
2. As index j should be greater than index i, inside loop i, we will run another loop i.e. j from i+1 to N-1, and
 select the element a[j].
3. Inside this second loop, we will check if a[i] > 2*a[j] i.e. if a[i] and a[j] can be a pair. If they satisfy the
 condition, we will increase the count by 1.
4. Finally, we will return the count i.e. the number of such pairs.
 */

// Algorithm : Optimal Solution
/*
Approach:
The steps are basically the same as they are in the case of the merge sort algorithm. The change will be just in the mergeSort() function:

1. In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the mergeSort().
2. We will add the numbers returned by the previous mergeSort() calls.
3. Before the merge step, we will count the number of pairs using a function, named countPairs().
4. We need to remember that the left half starts from low and ends at mid, and the right half starts from mid+1 and ends at high.

The steps of the countPairs() function will be as follows:

1. We will declare a variable, cnt, initialized with 0.
2. We will run a loop from low to mid, to select an element at a time from the left half.
3. Inside that loop, we will use another loop to check how many elements from the right half can make a pair.
4. Lastly, we will add the total number of elements i.e. (right-(mid+1)) (where right = current index), to the cnt and return it.
 */