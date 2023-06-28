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

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)
