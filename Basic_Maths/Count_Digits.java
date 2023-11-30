package Basic_Maths;

class Count_Digits {

    // Optimal Approach
    static int count_Digits (int num) {
        // int count = 0;
        while(num != 0) {
            int lastDigit = num % 10;
            System.out.println(lastDigit);
            // count++;
            num = num / 10;
        }
        return 0;
        // return count;
    }

    // Main Function
    public static void main(String[] args) {
        int result = count_Digits(778989);
        System.out.println(result);
    }
}

// Approach
/*
1. Store the integer in a variable X and initialize a counter variable to count the number of digits.
2. We know that in programming languages when we divide X by Y it will result in an integer
(given both the variables are integers). For example, 133/10 will result in 13 similarly 1/10 will result in 0.
3. Using a for loop and above observation keep on dividing X by 10 and increment the count in every iteration
when X equals 0 terminate the loop and the count will have the number of digits in N.
 */

/* Time & Space Complexity
Time Complexity: O (1)
Space Complexity: O(1)
 */