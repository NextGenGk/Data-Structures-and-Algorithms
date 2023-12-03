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

// Algorithm
/*
The function palindrome takes two arguments: a string str and an index i.
The base case is when i is greater than or equal to half the length of the string (str.length()/2). When the
recursion has reached or passed the middle of the string, it returns true, signifying that the string is
a palindrome up to that point.
Inside the function, it compares characters at two positions in the string:
str.charAt(i) represents the character at index i.
str.charAt(str.length()-i-1) represents the character at the symmetric position from the end of the string.
If these characters don't match, the function returns false, indicating that the string is not a palindrome.
If the characters match, it proceeds with the recursive call by incrementing i by 1 (i+1).
 */

// Time & Space Complexity -
// Time Complexity - O(n)
// Space Complexity - O(n)