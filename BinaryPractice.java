public class BinaryPractice {

    // Implement lower bound
    static int lowerBound(int[] arr, int target) {
        int n = arr.length;

        for (int i=0; i<n; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return n;
    }

    static int lowerBound2(int[] arr, int target) {
        int n = arr.length;
        int ans = n;

        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid-1;
            }
            // do not alter tha answer because this
            // doesn't have a probability to be my answer
            else low = mid + 1;
        }
        return ans;
    }

    // Implement upper bound
    static int upperBound2(int[] arr, int target) {
        int n = arr.length;
        int ans = n;

        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid-1;
            }
            // do not alter tha answer because this
            // doesn't have a probability to be my answer
            else low = mid + 1;
        }
        return ans;
    }

    // Search Insert Position
    // Brute
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return n;
    }

    // Optimal
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int ans = lowerBound(arr, 15);
        System.out.println(ans);
    }
}
