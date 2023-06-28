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
