package Basic_Recursion;

public class Sum_of_n_Natural_Number {
    // Function 1
    static int sum_of_n(int i, int n) {
        int sum = 0;
        if(i > n) {
            return sum;
        }
        sum = sum + i;
        return sum + sum_of_n(i+1, n);
    }

    // Function 2
     static int func(int n) {
        if(n == 0) {
            return 0;
        }    
        return n + func(n-1);
     }


    // Main Function
    public static void main(String[] args) {
        int n = 10;
        // System.out.println(sum_of_n(1, n));
        int res = func(n);
        System.out.println(res);
    }
}

// Algorithm (Recursive)
/*
1. The function takes an integer n as input.
2. If n is equal to 0, it returns 0. This serves as the base case for the recursion because the
sum of integers from 1 to 0 is 0.
3. If n is greater than 0, it recursively calls itself with n-1 and adds the current value of n to the
result of the function called with n-1.
 */

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)