package Strings;

import java.util.Stack;

public class Remove_Outermost_Parentheses {

    // Without Using Stack Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balanceCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balanceCount > 0) {
                    result.append("(");
                }
                balanceCount++;;
            }
            else {
                balanceCount--;
                if (balanceCount > 0) {
                    result.append(")");
                }
            }
        }
        return result.toString();
    }

    // With Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static String removeOuterParentheses2(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    result.append(c);
                }
                stack.push(c);
            }
            else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}

// Algorithm (Without Stack)
/*
We define a function removeOuterParentheses that takes a string s as input and returns a string.
We initialize a StringBuilder named result to efficiently build the final result, and an int variable balanceCount
to keep track of the balance of parentheses.
We iterate through each character c in the input string s using the enhanced for loop (for (char c : s.toCharArray())).

Inside the loop, we check if the current character is an opening parenthesis '('.
a. If it is an opening parenthesis and the balanceCount is greater than 0, it means this is not the outermost
parenthesis of a primitive string. So, we append it to the result.
b. We then increment the balanceCount.

If the current character is a closing parenthesis ')':
a. We decrement the balanceCount.
b. If the balanceCount is still greater than 0, it means this is not the outermost parenthesis of a primitive string.
So, we append it to the result.

After the loop, we return the final result by converting the StringBuilder to a string using result.toString().
 */

// Algorithm (With Stack)
/*
We define a function removeOuterParentheses that takes a string s as input and returns a string.
We initialize a StringBuilder named result to efficiently build the final result, and an int variable balanceCount
to keep track of the balance of parentheses.
We iterate through each character c in the input string s using the enhanced for loop (for (char c : s.toCharArray())).

Inside the loop, we check if the current character is an opening parenthesis '('.
a. If it is an opening parenthesis and the balanceCount is greater than 0, it means this is not the outermost
parenthesis of a primitive string. So, we append it to the result.
b. We then increment the balanceCount.

If the current character is a closing parenthesis ')':
a. We decrement the balanceCount.
b. If the balanceCount is still greater than 0, it means this is not the outermost parenthesis of a primitive string.
So, we append it to the result.

After the loop, we return the final result by converting the StringBuilder to a string using result.toString().
 */