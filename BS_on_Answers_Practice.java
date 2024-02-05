import java.util.ArrayList;
import java.util.Arrays;

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

    public static int smallestDivisor(int[] arr, int limit) {
        int ans = -1;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

//        for (int i=mini; i<=maxi; i++) {
//
//            if (findDivisor(arr, i) <= limit) {
//                ans = i;
//                break;
//            }
//        }
//        return ans;
        int low = mini;
        int high = maxi;

        while (low <= high) {
            int mid = low + high / 2;
            if (findDivisor(arr, mid) <= limit) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findDivisor(int[] arr, int divisor) {
        int total = 0;
        for (int i=0; i<arr.length; i++) {
            total += Math.ceil((double) arr[i] / (double) divisor);
        }
        return total;
    }

    // Capacity to Ship Packages within D Days

    public static int leastWeightCapacity(int[] weights, int d) {
        // Write your code here.
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<weights.length; i++) {
            sum += weights[i];
            maxi = Math.max(weights[i], maxi);
        }

        // for (int i=maxi; i<=sum; i++) {
        //     if(findDays(weights, i) <= d) {
        //         return i;
        //     }
        // }

        int low = maxi;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (findDays(weights, mid) <= d) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findDays(int[] weights, int cap) {
        int days = 1;
        int load = 0;

        for (int i=0; i<weights.length; i++) {
            if (load + weights[i] > cap) {
                days += 1;
                load = weights[i];
            }
            else {
                load += weights[i];
            }
        }
        return days;
    }

    // Kth Missing Positive Integer
    public static int missingK(int[] vec, int n, int k) {
        // Write your code here.
        int low =  0;
        int high = n-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = vec[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return (high + 1 + k);
    }

    // Aggressive Cows
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int min = stalls[0];
        int max = stalls[stalls.length-1];

        // for (int i=1; i<max-min; i++) {
        //     if (canWePlace(stalls, i, k)) {
        //         continue;
        //     }
        //     else {
        //         return i-1;
        //     }
        // }
        // return max-min;

        int low = 1;
        int high = max - min;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k)) {
                low = mid +  1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean canWePlace(int[] stalls, int distance, int cows) {
        int countCows = 1;
        int lastCoordinate = stalls[0];

        for (int i=1; i<stalls.length; i++) {
            if (stalls[i] - lastCoordinate >= distance) {
                countCows += 1;
                lastCoordinate = stalls[i];
            }
        }
        if (countCows >= cows) return true;
        return false;
    }

    // Book Allocation Problem
    public static int findPages(int[] arr, int n, int students) {
        // Write your code here.
        if (students > n) return -1;
        int summation = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            summation += arr[i];
            maxi = Math.max(maxi, arr[i]);
        }

//        for (int i=maxi; i<=summation; i++) {
//            if (allocateBooks(arr, i) == students) {
//                return i;
//            }
//        }
//        return -1;

        int low = maxi;
        int high = summation;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (allocateBooks(arr, mid) > students) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int allocateBooks(int[]  arr, int noOfBooks) {
        int student = 1;
        int pagesStudents = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] + pagesStudents <= noOfBooks) {
                pagesStudents += arr[i];
            }
            else {
                student+=1;
                pagesStudents = arr[i];
            }
        }
        return student;
    }

    // Split array largest sum
    public static int largestSubarraySumMinimized(int []a, int k) {
        // Write Your Code Here
        int n = a.length;

        if (k > n) return -1;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            sum += a[i];
            maxi = Math.max(a[i], maxi);
        }

        // for (int i=maxi; i<=sum; i++) {
        //     if (countSubarray(a, i) == k) {
        //         return i;
        //     }
        // }
        // return maxi;

        int low = maxi;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (countSubarray(a, mid) > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countSubarray(int[] a, int values) {
        int n = a.length;
        int arrayCount = 1;
        int sumCount = 0;

        for (int i=0; i<n; i++) {
            if (a[i] + sumCount <= values) {
                sumCount += a[i];
            }
            else {
                arrayCount++;
                sumCount = a[i];
            }
        }
        return arrayCount;
    }

    // Painter's Partition
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int n = boards.size();

        if (k > n) return -1;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            sum += boards.get(i);
            maxi = Math.max(maxi, boards.get(i));
        }

        // for (int i=maxi; i<= sum; i++) {
        //     if (findK(boards, i) == k) {
        //         return i;
        //     }
        // }
        // return maxi;

        int low = maxi;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (findK(boards, mid) > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int findK(ArrayList<Integer> boards, int values) {
        int countK = 1;
        int valuesOfK = 0;

        for (int i=0; i<boards.size(); i++) {
            if (valuesOfK + boards.get(i) <= values) {
                valuesOfK += boards.get(i);
            }
            else {
                countK++;
                valuesOfK = boards.get(i);
            }
        }
        return countK;
    }

    // Median of Two Sorted Array
    public static double median(int[] a, int[] b) {
        // Write your code here.
        int n1 = a.length;
        int n2 = b.length;

        int n = (n1 + n2);

        if (n1 > n2) return median(b, a);
        int left = (n1 + n2 + 1) / 2;
        int low = 0;
        int high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = a[mid1];
            if (mid2 < n2) r2 = b[mid2];
            if (mid1 - 1 >= 0) l1 = a[mid1-1];
            if (mid2 - 1 >= 0) l2 = b[mid2-1];
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }

    // Kth Element in Two Sorted Array
    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int n1, int n2, int k) {
        if (n1 > n2) {
            return kthElement(b, a, n2, n1, k);
        }

        int low = Math.max(0, k - n2);
        int high = Math.min(n1, k);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 > 0) ? a.get(mid1 - 1) : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b.get(mid2 - 1) : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a.get(mid1) : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b.get(mid2) : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    // Find Maximum Numbers of One in Row Wise Sorted Matrix
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Write your code here.
        int index = -1;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int countOnes = m - lowerBound(matrix.get(i), m, 1);
            if (countOnes > maxCount) {
                maxCount = countOnes;
                index = i;
            }
        }
        return index;
    }

    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};
        int n = 4, m = 2;
        int ans = findPages(arr, n, m);
        System.out.println(ans);
    }
}
