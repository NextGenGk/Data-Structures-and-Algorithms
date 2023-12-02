package Basic_Maths;

public class isPrime {

    // Brute Force
    public static void prime (int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(n%i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("Prime");
        }
        else {
            System.out.println("Not a Prime");
        }
    }

    // Optimal Approach
    public static void primev2 (int n) {
        int count = 0;
        for (int i=1; i<= (int)Math.sqrt(n); i++)
            if(n % i == 0) {
                count++;
                if(n % i != i) {
                    count++;
                }
            }
        if (count == 2) {
            System.out.println("Prime");
        }
        else {
            System.out.println("Not a Prime");
        }
    }

    // Main Function
    public static void main(String[] args) {
        prime(36);
        primev2(36);
    }
}

// Approach
/*
Approach: Running the for loop till the square root of the number

1. A prime number is a natural number that is only divisible by 1 and by itself. Examples 1 2 3 5 7 11 13 17 19 …
2. Using a for loop for checking if the number is divisible by a number from 2 to its square root.
3. Running the for loop from 2 to the square root of the number.
4. And then checking if the number is divisible by the numbers from 2 to its square root.
5. Then, If the remainder is zero, that means it is divisible and hence not a prime number.

If the loop runs till square root and none of the numbers divided it completely. So it is the Prime number.
 */

// Time & Space Complexity
/*
Time Complexity: O(√n)
Space Complexity: O(1)
 */