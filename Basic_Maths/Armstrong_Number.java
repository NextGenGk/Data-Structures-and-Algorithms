package Basic_Maths;

public class Armstrong_Number {

    // Optimal Approach
    static boolean armstrong (int n) {
        int sum = 0;
        int dup = n;
        while (n > 0) {
            int lastDigit = n % 10;
            sum = sum + (lastDigit * lastDigit * lastDigit);
            n = n / 10;
        }
        if (dup == sum) {
            return true;
        }
        else {
            return false;
        }
    }

    // Main Function
    public static void main(String[] args) {
        boolean result = armstrong(170);
        System.out.println(result);
    }
}

// Approach
/*
Approach:

Let us check one 3-digit Armstrong Number
n=153
sum=0
No. of digits = 3 so we need to cube every digit.
In the First iteration, extract digit 3 from 153 and cube it which becomes 27, add it to sum= 0+27=27 which becomes 27 now
In Second iteration , extract digit 5 from 15 and cube it which becomes 125 , add it to sum = 27 +125 = 152 which becomes 152 now
In Third iteration , extract digit 1 from 1 and cube it which becomes 1 , add it to sum = 152 + 1 = 153 which becomes 153 now.
The original Number was 153 and the sum of cubes = 153.
 */

// Time & Space Complexity
/*
Time Complexity: O(n) where n is the number of digits since we need to traverse every digit and add digits
raised to power no. of digits to sum.
Space Complexity: O(1) since no extra space is required
 */