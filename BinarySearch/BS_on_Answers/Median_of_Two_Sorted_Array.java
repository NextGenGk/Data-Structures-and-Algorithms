package BinarySearch.BS_on_Answers;

import java.util.ArrayList;
import java.util.List;

public class Median_of_Two_Sorted_Array {

    // Method 1 : Brute Force
    // Time : O(n1+n2), where n1 and n2 are the sizes of the given arrays.
    // Reason: We traverse through both arrays linearly.
    // Space : O(n1+n2), where n1 and n2 are the sizes of the given arrays.
    // Reason: We are using an extra array of size (n1+n2) to solve this problem.
//    public static double median(int[] a, int[] b) {
//        // Size of two given arrays
//        int n1 = a.length;
//        int n2 = b.length;
//
//        List<Integer> arr3 = new ArrayList<>();
//        // Apply the merge step
//        int i = 0, j = 0, k = 0;
//        while (i < n1 && j < n2) {
//            if (a[i] < b[j]) {
//                arr3.add(a[i++]);
//            } else {
//                arr3.add(b[j++]);
//            }
//        }
//
//        // Copy the left-out elements
//        while (i < n1) {
//            arr3.add(a[i++]);
//        }
//        while (j < n2) {
//            arr3.add(b[j++]);
//        }
//
//        // Find the median
//        int n = n1 + n2;
//        if (n % 2 == 1) {
//            return (double) arr3.get(n / 2);
//        }
//
//        double median = ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1)) / 2.0;
//        return median;
//    }

    // Method 2 : Better Solution
    // Time : O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
    // Reason: We traverse through both arrays linearly.
    // Space : O(1), as we are not using any extra space to solve this problem.
    public static double median(int[] a, int[] b) {
        // Size of two given arrays
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2; //total size
        //required indices:
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        //apply the merge step:
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                cnt++;
                j++;
            }
        }

        //copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1) ind1el = a[i];
            if (cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1) ind1el = b[j];
            if (cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }

        //Find the median:
        if (n % 2 == 1) {
            return (double)ind2el;
        }

        return (double)((double)(ind1el + ind2el)) / 2.0;
    }

    // Main Function
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + median(a, b));
    }
}

// Output :
// Output: The median of two sorted arrays is 6.0

// Algorithm : Brute Force
/*
Naive Approach(Brute-force):
The extremely naive approach is to merge the two sorted arrays and then find the median in that merged array.

How to merge two sorted arrays:

The word “merge” suggests applying the merge step of the merge sort algorithm. In that step, we essentially perform
the same actions as required by this solution. By using two pointers on two given arrays, we fill up the elements into
a third array.

How to find the median:

1. If the length of the merged array (n1+n2) is even: The median is the average of the two middle elements.
index = (n1+n2) / 2, median = (arr3[index] + arr3[index-1]) / 2.0.
2. If the length of the merged array (n1+n2) is odd: index = (n1+n2) / 2,
median = arr3[index].

Algorithm:

1. We will use a third array i.e. arr3[] of size (n1+n2) to store the elements of the two sorted arrays.
2. Now, we will take two pointers i and j, where i points to the first element of arr1[] and j points to the first
element of arr2[].
3. Next, using a while loop( while(i < n1 && j < n2)), we will select two elements i.e. arr1[i] and arr2[j], and
consider the smallest one among the two. Then, we will insert the smallest element in the third array and increase
that specific pointer by 1.
    1. If arr1[i] < arr2[j]: Insert arr1[i] into the third array and increase i by 1.
    2. Otherwise: Insert arr2[j] into the third array and increase j by 1.
4. After that, the left-out elements from both arrays will be copied as it is into the third array.
5. Now, the third array i.e. arr3[] will be the sorted merged array. Now the median will be the following:
    1. If the length of arr3[] i.e. (n1+n2) is even: The median is the average of the two middle elements.
    index = (n1+n2) / 2, median = (arr3[index] + arr3[index-1]) / 2.0.
    2. If the length of arr3[] i.e. (n1+n2) is odd: index = (n1+n2) / 2,
median = arr3[index].
6. Finally, we will return the value of the median.
 */

// Algorithm : Better Solution
/*
Algorithm / Intuition
To optimize the space used in the previous approach, we can eliminate the third array used to store the
final merged result. After closer examination, we realize that we only need the two middle elements at
indices (n1+n2)/2 and ((n1+n2)/2)-1, rather than the entire merged array, to solve the problem effectively.

We will stick to the same basic approach, but instead of storing elements in a separate array, we will
use a counter called ‘cnt’ to represent the imaginary third array’s index. As we traverse through the
arrays, when ‘cnt’ reaches either index (n1+n2)/2 or ((n1+n2)/2)-1, we will store that particular element.
This way, we can achieve the same goal without using any extra space.

Algorithm:
1. We will call the required indices as ind2 = (n1+n2)/2 and ind1 = ((n1+n2)/2)-1. Now we will declare the counter
called ‘cnt’ and initialize it with 0.
2. Now, as usual, we will take two pointers i and j, where i points to the first element of arr1[] and j points to the
first element of arr2[].
3. Next, using a while loop( while(i < n1 && j < n2)), we will select two elements i.e. arr1[i] and arr2[j], and
consider the smallest one among the two. Then, we will increase that specific pointer by 1.
In addition to that, in each iteration, we will check if the counter ‘cnt’ hits the indices ind1 or ind2. when ‘cnt’
reaches either index ind1 or ind2, we will store that particular element. We will also increase the ‘cnt’ by 1 every
time regardless of matching the conditions.
    1. If arr1[i] < arr2[j]: Check ‘cnt’ to perform necessary operations and increase i and ‘cnt’ by 1.
    2. Otherwise: Check ‘cnt’ to perform necessary operations and increase j and ‘cnt’ by 1.
4. After that, the left-out elements from both arrays will be copied as it is into the third array. While copying we
will again check the above-said conditions for the counter, ‘cnt’ and increase it by 1.
5. Now, let’s call the elements at the required indices as ind1el(at ind1) and ind2el(at ind2):
    1. If the total length i.e. (n1+n2) is even: The median is the average of the two middle elements.
    median = (ind1el + ind2el) / 2.0.
    2. If the total length i.e. (n1+n2) is odd: median = ind2el.
6. Finally, we will return the value of the median.
 */