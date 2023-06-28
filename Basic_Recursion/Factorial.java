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

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)