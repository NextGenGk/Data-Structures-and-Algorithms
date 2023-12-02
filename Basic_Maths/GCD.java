package Basic_Maths;

public class GCD {
    // Brute Force
    public static int gcd(int n1, int n2) {
        int gcd = 1;
        for(int i=1; i<= Math.min(n1, n2); i++) {
            if(n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // Simple Observation
    public static void gcd2(int n1, int n2) {
        for(int i=Math.min(n1, n2); i>=0; i--) {
            if(n1 % i == 0 && n2 % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    // Euclid's Algorithm (Idea)
    public static int gcd3(int n1, int n2) {
        while(n1 > 0 && n2 > 0) {
            if(n1 > n2) n1 = n1 % n2;
            else n2 = n2 % n1;
        }
        if(n1 == 0) return n2;
        else return n1;
    }

    // Formula (Euclid's Algorithm) gcd(a,b) = gcd(b, a%b) where, a>0
    public static int gcd4(int n1, int n2) {
        if(n2 == 0) {
            return n1;
        }
        return gcd4(n2, n1%n2);
    }

    // Main Function
    public static void main(String[] args) {
         int result = gcd(20,40);
         System.out.println(result);
         gcd2(20,40);
//        int res2 = gcd3(20,40);
//        System.out.println(res2);
//        int result = gcd4(20,40);
//        System.out.println(result);
    }
}

// Time & Space Complexity (Optimal Solution)
/*
Time Complexity: O(logɸmin(a,b)), where ɸ is 1.61.
Space Complexity: O(1).
 */