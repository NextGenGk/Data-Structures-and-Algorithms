package Basic_Maths;

public class Reverse_Number {

    // Optimal Approach
    static int count (int num) {
        int rev = 0;
        while(num != 0) {
            int lastDigit = num % 10;
            rev = (rev * 10) + lastDigit;
            num = num / 10;
        }
        return rev;
    }

    // Main Function
    public static void main(String[] args) {
        int result = count(1236);
        System.out.println(result);
    }
}

// Approach
/*
1. Run a while loop until the given number N is equal to zero while(N!=0)
2. a variable reverse = 0;
3. now in each step take the remainder of the given number N and store it as a variable digit, digit = N % 10
4. Also, Divide the number by 10. N= N / 10
5. in each step, the variable reverse get updated as reverse = reverse*10+digit.
 */

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)