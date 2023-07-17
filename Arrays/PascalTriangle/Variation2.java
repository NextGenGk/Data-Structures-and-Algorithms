package Arrays.PascalTriangle;

public class Variation2 {

    // Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

    // Calculating nCr
    // Time - O(r)
    static int nCr(int n, int r) {
        long ans = 1;
        for (int i=0; i<r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }
        return (int) ans;
    }

    // Method 1 - Brute Force
    // Time - O(n * r), Space - O(1)
    static void pascalTriangle(int n) {
        for (int col=1; col<=n; col++) {
            System.out.print(nCr(n-1, col-1) + " ");
        }
    }

    // Method 2 - Optimal Solution
    // Time - O(N), Space - O(1)
    static void pascalTriangleOptimal(int n) {
        long ans = 1;
        System.out.print(ans + " ");

        for (int i=1; i<n; i++) { // print the row
            ans = ans * (n - i);
            ans = ans / (i);
            System.out.print(ans + " ");
        }
    }

    // Main Function
    public static void main(String[] args) {
        // Variation 2:
        int n = 5; // row number
        // pascalTriangle(n);
        pascalTriangleOptimal(n);
    }
}

// Output :
// 1 4 6 4 1

// Algorithm : Brute Force
/*
1. We will use a loop(say c) to iterate over each column i.e. from 1 to n. And for each column, we will do the following steps:
    1. First, we will consider n-1 as n and c-1 as r.
    2. After that, we will simply calculate the value of the combination using a loop.
    3. The loop will run from 0 to r. And in each iteration, we will multiply (n-i) with the result and divide the result by (i+1).
    4. Finally, we will print the element.
2. Finally, the entire row will be printed.
 */

// Algorithm : Optimal Solution
/*
1. First, we will print the 1st element i.e. 1 manually.
2. After that, we will use a loop(say i) that runs from 1 to n-1. It will print the rest of the elements.
3. Inside the loop, we will use the above-said formula to print the element. We will multiply the previous answer by (n-i) and then divide it by i itself.
4. Thus, the entire row will be printed.
 */

// Striver : (Video Explanation) https://youtu.be/bR7mQgwQ_o8