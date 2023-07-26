package Arrays;

public class Find_Repeating_and_Missing_Number {

    // Method 1: Brute Force
    // Time Complexity: O(N^2), where N = the size of the given array.
    // Reason: We are using two loops each running for N times. So, the time complexity will be O(N^2).
    // Space Complexity: O(1) as we are not using any extra space.
    static int[] findMissingRepeatingNumbers(int[] arr) {
        int n = arr.length; // size of the array
        int repeating = -1, missing = -1;

        //Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            //Count the occurrences:
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) cnt++;
            }

            if (cnt == 2) repeating = i;
            else if (cnt == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }

    // Method 2 : Better Solution
    // Time Complexity: O(2N), where N = the size of the given array.
    // Reason: We are using two loops each running for N times. So, the time complexity will be O(2N).
    // Space Complexity: O(N) as we are using a hash array to solve this problem.
    static int[] findMissingRepeatingNumbers1(int[] arr) {
        int n = arr.length; // size of the array
        int[] hash = new int[n + 1]; // hash array

        //update the hash array:
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        //Find the repeating and missing number:
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) repeating = i;
            else if (hash[i] == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }


    // Main Function
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbers1(a);
        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
    }
}

// Output: The repeating and missing numbers are: {5, 8}

// Algorithm : Brute Force
/*
1. We will run a loop(say i) from 1 to N.
2. For each integer, i, we will count its occurrence in the given array using linear search.
3. We will store those two elements that have the occurrence of 2 and 0.
4. Finally, we will return the elements.
 */

// Algorithm : Better Solution
/*
1. The range of the number is 1 to N. So, we need a hash array of size N+1 (as we want to store the frequency of N as well).
2. We will iterate all the elements of the given array and update the hash array accordingly i.e. hash[a[i]] = hash[a[i]]+1.
3. Now, we will iterate on the hash array and return the two elements with frequencies 2 and 0.
 */