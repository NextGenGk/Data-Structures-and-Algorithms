package Basic_Recursion;

public class Palindrome_String {

    // Function
    static boolean palindrome(String str, int i) {
        if (i >= str.length()/2) {
            return true;
        }
        if (str.charAt(i) != str.charAt(str.length()-i-1)) {
            return false;
        }
        return palindrome(str, i+1);
    }

    // Main Function
    public static void main(String[] args) {
        String str = "madam";
        boolean res = palindrome(str, 0);
        System.out.println(res);
    }
}

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)