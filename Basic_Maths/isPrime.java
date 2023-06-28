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
