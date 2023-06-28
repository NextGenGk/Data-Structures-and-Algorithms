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

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)