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
