package Basic_Maths;

public class Print_All_Divisors {

    // Brute Force
    static int divisor (int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        return count;
    }

    // Optimal Approach
    public static void divisor2 (int n) {
        for (int i=1; i<= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
              System.out.print(i + " ");
                 if (i != n%i) {
                   System.out.print(n/i + " ");
                 }
            }
            System.out.println();
        }
    }

    // Main Function
    public static void main(String[] args) {
        int result = divisor(36);
        System.out.println(result);
        divisor2 (36);
    }
}

// Approach
/*
1. From the intuition, we can come to the conclusion that we don’t need to traverse all the candidates and if we found
a single divisor, we can also find another divisor(Here, we need to be careful, if the given number is a perfect square,
 like 36, 6 also give 6 as quotient. This is a corner case.)
2. keeping these in mind, it is enough if we traverse up to the root of a number. Whenever we find a divisor, we print
 it and also print the quotient. If the quotient is the same, we ignore it. Because the root of a perfect square will
 give the same quotient as itself.
3. The quotients are the numbers that are on the other side of the root. So, it’s okay if we stop traversing at the root.
4. This approach is more time efficient than the previous one. But the output sequences are not the same. In the
previous approach, we get an ordered output unlike here.
 */

// Time & Space Complexity
/*
Time Complexity: O(sqrt(n)), because every time the loop runs only sqrt(n) times.
Space Complexity: O(1), we are not using any extra space.
 */