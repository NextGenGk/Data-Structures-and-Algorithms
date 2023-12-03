package Basic_Recursion;

public class Factorial {

    // Function
    static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }

    // Main Function
    public static void main(String[] args) {
        int n = 5;
        int res = factorial(n);
        System.out.println(res);
    }
}

// Algorithm
/*
1. The function factorial takes an integer n as input.
2. If n is equal to 0, it returns 1. This serves as the base case for the factorial function because the
factorial of 0 is defined as 1.
3. If n is greater than 0, it recursively calls itself with n-1 and multiplies the current value of n
with the result of the factorial of n-1. This continues until n reaches 0.
 */

/*
For example, if you call this function with a value of 5 (factorial(5)), here's what happens:

factorial(5) returns 5 * factorial(4)
factorial(4) returns 4 * factorial(3)
factorial(3) returns 3 * factorial(2)
factorial(2) returns 2 * factorial(1)
factorial(1) returns 1 * factorial(0)
factorial(0) reaches the base case and returns 1
 */

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)