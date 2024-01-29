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

    // Find Maximum Element Function
    static int findMaximumElement(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            if (arr[i] > maxi) {
                maxi = arr[i];
            }
        }
        return maxi;
    }

    // Calculate Total Hours Function
    static int calculateTotalHours(int[] arr, int hourly) {
        int n = arr.length;
        int totalHours = 0;

        for (int i=0; i<n; i++) {
            totalHours +=  Math.ceil((double) arr[i] / (double) hourly);
        }
        return totalHours;
    }

    static int minimumRateToEatBananas(int[] arr, int hours) {
        int low = 1;
        int high = findMaximumElement(arr);

        while (low <= high) {
            int mid = (low + high) / 2;
            int reqTime = calculateTotalHours(arr, mid);
            if (reqTime <= hours) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    // Minimum number of day to make M bouquets
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length; // Size of the array
        if (val > n) return -1; // Impossible case.
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        int low = mini;
        int high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }
}
