package Strings;

public class Reverse_Words_In_A_String {

    // Optimal Solution
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static String reverseString(String str) {
        StringBuilder result = new StringBuilder();
        int i = str.length() - 1;

        while (i >= 0) {
            while (i >= 0 && str.charAt(i) == ' ') {
                i--;
            }
            int j = i;

            if (i < 0)
                break;

            while (i >= 0 && str.charAt(i) != ' ') {
                i--;
            }

            if (result.isEmpty()) {
                result.append(str.substring(i + 1, j + 1));
            } else {
                result.append(" ").append(str.substring(i + 1, j + 1));
            }
        }
        return result.toString();
    }
}

// Explanation
/*
1. StringBuilder result = new StringBuilder();: This creates a StringBuilder instance named result that will be
used to build the reversed words.
2. int i = str.length() - 1;: Initializes the variable i to the index of the last character in the input string str.
3. The code then enters a while loop that iterates through the characters of the input string in reverse order.
    1. The first while loop (while (i >= 0 && str.charAt(i) == ' ')) is used to skip trailing spaces.
    2. The variable j is then set to the current value of i.
    3. The second while loop (while (i >= 0 && str.charAt(i) != ' ')) is used to move to the beginning of
    the current word.
    4. The code then appends the current word to the result StringBuilder.
4. The loop continues until it reaches the beginning of the input string.
5. The method returns the reversed string obtained by calling result.toString().
 */