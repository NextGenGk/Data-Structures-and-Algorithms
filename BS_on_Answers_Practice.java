public class BS_on_Answers_Practice {
    // Find Square root of N
    int floorSqrt(int n) {
        // Write your code here.
        long low = 1;
        long high = n;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (mid * mid <= n) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return (int) high;
    }

    // Find Nth Root
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 0;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (findMidPowerM(mid, n, m) == 1) {
                return mid;
            }
            else if (findMidPowerM(mid, n, m) == 2) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    // Helper function to find mid^n
    public static int findMidPowerM(int mid, int n, int m) {
        long ans =  1;
        for (int i=1; i<=n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        else return 0;
    }
}
