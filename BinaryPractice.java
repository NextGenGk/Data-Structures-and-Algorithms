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

    // Find Minimum in Rotated Sorted Array
    public static int findMin(int []arr) {
        // Write your code here.
        int low = 0;
        int high = arr.length-1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }
            else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    // Find ot how many times the array has been rotated
    public static int findKRotation(int []arr){
        // Write your code here.
        int low = 0;
        int high = arr.length-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            }
            else {
                if (arr[mid] <= arr[high]) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }

    static int singleElement1(int[] arr) {
        int n = arr.length;

        if (n == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n-1] != arr[n-2]) return arr[n-1];

        int low = 1;
        int high = n-2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) return arr[mid];
            if ((mid % 2 == 1) && arr[mid] == arr[mid-1] || (mid % 2 == 0) && arr[mid] == arr[mid+1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Find Peak Element
    public static int findPeakElement(ArrayList<Integer> arr) {
        // Write your code here.
        int n = arr.size();

        if (n == 1) return 0;
        if (arr.get(0) > arr.get(1)) return 0;
        if (arr.get(n-1) > arr.get(n-2)) return n - 1;

        int low = 1;
        int high = n-2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) > arr.get(mid-1) && arr.get(mid) > arr.get(mid+1)) {
                return mid;
            }
            else if (arr.get(mid) > arr.get(mid-1)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
        int res = singleElement1(arr);
        System.out.println(res);
    }
}
