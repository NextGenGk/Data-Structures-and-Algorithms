package Basic_Maths;

public class isPalindrome {

    // Optimal Approach
    static boolean isPalindrome(int n) {
        int rev = 0;
        int dup = n;
        while (n != 0) {
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n = n / 10;
        }
        if (dup == rev) {
            return true;
        } else {
            return false;
        }
    }

    // Main Function
    public static void main(String[] args) {
        boolean result = isPalindrome(121);
        System.out.println(result);
    }
}

// Approach
/*
Approach:  We can reverse the original number and compare the original with the reversed number. If both are the same,
the number qualifies as a palindrome number.

Say the input number is X. Declare a variable Y to store the reverse and initialize it to 0. Make a copy of X,
say dummy that will be used later for comparison.

Let’s understand the procedure to reverse a number.

1. At every step extract the last digit using the % operator. Suppose X%10 = d.
2. We will append this last digit, d to Y using a formula 10*Y+d.
3. The last digit of X has been used. Discard it using X/10.
Repeat these steps for the remaining digits. After every iteration, the size of X will shrink by one digit.
 Terminate the iteration when X = 0 meaning no new digits are left to be reversed.

The reversed number Y is compared with the dummy variable since X was destroyed while iteration. If Y equals dummy
print “Palindrome Number” otherwise “Not Palindrome Number”.
 */

// Time & Space Complexity
/*
Time Complexity: O(logN) for reversing N digits of input integer.
Space Complexity: O(1)
 */