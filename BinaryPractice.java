import java.util.ArrayList;
import java.util.Arrays;

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

    // Floor & Ceil
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Write your code here.
        int ceil = -1;
        int floor = -1;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (a[mid] <= x) {
                floor = a[mid];
                // look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }

            // maybe an answer
            if (a[mid] >= x) {
                ceil = a[mid];
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return new int[]{floor, ceil};
    }

    // Find First & Last Occurrences
    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == k) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[]{first, last};
    }

    public static int[] firstAndLastPosition2(int[] arr, int n, int k) {
        int lb = lowerBound(arr, k);
        if (lb == n && lb != k) return new int[]{-1, -1};
        return new int[]{lb, upperBound2(arr, k) - 1};
    }

    // Count occurrences in a sorted array
    public static int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    public static int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    public static int count(int arr[], int n, int x) {
        int first = firstOccurrence(arr, n, x);
        if (first == -1) return 0;

        int last = lastOccurrence(arr, n, x);
        return (last - first) + 1;
    }

    // Search in rotated sorted array
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // Search in Rotated Sorted Array II
    public boolean search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return true;

            // if both parts are sorted
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int n = 8, k = 8;
        int[] ans = firstAndLastPosition2(arr, n, k);
        System.out.println("The first and last positions are: "
                + ans[0] + " " + ans[1]);
    }
}
