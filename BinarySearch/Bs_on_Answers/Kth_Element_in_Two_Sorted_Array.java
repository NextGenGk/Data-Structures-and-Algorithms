package BinarySearch.BS_on_Answers;

public class Kth_Element_in_Two_Sorted_Array {

    // Optimal Solution
    // Time Complexity : log(min(m,n))
    // Reason: We are applying binary search in the array with minimum size among the two. And we know
    // the time complexity of the binary search is log(N) where N is the size of the array. Thus,
    // the time complexity of this approach is log(min(m,n)), where m, and n are the sizes of two arrays.
    // Space Complexity: O(1)
    // Reason: Since no extra data structure is used, making space complexity to O(1).
    static int kthelement(int arr1[], int arr2[], int m, int n, int k) {
        // if m is bigger swap the arrays:
        if (m > n) {
            return kthelement(arr2, arr1, n, m, k);
        }

        int totalLen = m + n; // total length
        int left = k; // length of left half
        // apply binary search:
        int low = Math.max(0, k-n);
        int high = Math.max(k, m);

        while (low <= high) {
            int mid1 = low + high / 2;
            int mid2 = k - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            // calculate l1, l2, r1 and r2;
            if (mid1 < m) r1 = arr1[mid1];
            if (mid2 < n) r2 = arr2[mid2];
            if (mid1 - 1 >= 0) l1 = arr1[mid1-1];
            if (mid2 - 1 >= 0) l2 = arr2[mid2-1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;   // dummy statement
    }

    // Main Function
    public static void main(String args[]) {
        int array1[] = {2,3,6,7,9};
        int array2[] = {1,4,8,10};
        int m = array1.length;
        int n = array2.length;
        int k = 5;
        System.out.println("The element at the kth position in the final " +
                "sorted array is " + kthelement(array1,array2,m,n,k));

        }
    }

// Output :
// The element at the kth position in the final sorted array is 6

// Approach :
/*
Approach :

Apply binary search in an array with a small size. Start iterating with two pointers, say left and right.
Find the middle of the range. Take elements from low to middle of array1 and the remaining elements from
the second array. Then using the condition mentioned above, check if the left half is valid. If valid,
print the maximum of both array’s last element. If not, move the range towards the right if l2 > r1,
else move the range towards the left if l1 > r2.
 */

// Video Explanation (Striver) : https://youtu.be/nv7F4PiLUzo