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
