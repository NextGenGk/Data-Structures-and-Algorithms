package Basic_Recursion;

public class Fibonacci {

    // Function
    public static int fib(int n) {
        if(n <= 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    // Main Function
    public static void main(String[] args) {
        int n = 10;
        int res = fib(n);
        System.out.println(res);
    }
}

// Algorithm
/*
1. The function fib takes an integer n as input.
2. If n is less than or equal to 1, the function returns n. This is the base case where the function returns
0 for n = 0 and 1 for n = 1, as these are the first two numbers in the Fibonacci sequence.
3. If n is greater than 1, it recursively calls itself to calculate the Fibonacci number by summing up the
(n-1)th and (n-2)th Fibonacci numbers using the formula fib(n-1) + fib(n-2).
 */

/*
fib(5) = fib(4) + fib(3)
       = (fib(3) + fib(2)) + (fib(2) + fib(1))
       = ((fib(2) + fib(1)) + (fib(1) + fib(0))) + ((fib(1) + fib(0)) + fib(1))
       = ((1 + 1) + (1 + 0)) + ((1 + 0) + 1)
       = (2 + 1) + (1 + 1)
       = 3 + 2
       = 5
 */

// Time & Space Complexity
/*
Time Complexity: O(2^N) { This problem involves two function calls for each iteration which further expands to 4
function calls and so on which makes worst-case time complexity to be exponential in nature }.
Space Complexity: O(N) { At maximum there could be N function calls waiting in the recursion stack since we need to
calculate the Nth Fibonacci number for which we also need to calculate (N-1) Fibonacci numbers before it }.
 */