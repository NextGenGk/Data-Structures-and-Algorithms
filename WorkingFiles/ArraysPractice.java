package WorkingFiles;

import java.lang.reflect.Array;
import java.util.*;

public class ArraysPractice {

    // 1st Question
//    static int array(int[] arr) {
//        Arrays.sort(arr);
//        return arr[arr.length-1];
//    }
    static void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    // second largest element
    static int secondLargest(int[] arr) {
        Arrays.sort(arr);
        int largest = arr[arr.length-1];
        int sLargest = -1;
        for (int i=arr.length-2; i>=0; i--) {
            if (arr[i] != largest) {
                sLargest = arr[i];
                break;
            }
        }
        return sLargest;
    }

    static int secondLargest2(int[] arr) {
        Arrays.sort(arr);
        int largest = arr[arr.length-1];
        int sLargest = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > sLargest && arr[i] != largest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }

    static int secondLargest3(int[] arr) {
        int largest = arr[0];
        int sLargest = -1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] < largest && arr[i] > sLargest) {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }

    static boolean sort(int[] arr) {

        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    static int removeDups(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                list.add(arr[i]);
            }
        }
        list.add(arr[arr.length - 1]);

        int x = 0;
        for (int i=0; i<list.size(); i++) {
            arr[x] = list.get(i);
            x++;
        }
        return x;
    }

    static int rem(int[] arr) {
        int i=0;
        for (int j=1; j<arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }

    static void leftRotate(int[] arr) {
        int temp = arr[0];
        for (int i=1; i<arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] =  temp;
    }

    static void leftRotateByD(int[] arr, int k) {
        int[] temp = new int[k];
        for (int i=0; i<k; i++) {
            temp[i] = arr[i];
        }

        for (int i=k; i< arr.length; i++) {
            arr[i-k] = arr[i];
        }

        int j= 0;
        for (int i= arr.length-k; i< arr.length; i++) {
            arr[i] = temp[j];
            j++;
        }
    }

    static void leftRotateByDv2(int[] arr, int k) {
        int n = arr.length;
        k = k%n;
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);
    }


    static void reverse(int[] arr, int low, int high) {
        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    static int[] moveAllZeroes(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int x = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] > 0) {
                temp[x] = arr[i];
                x++;
            }
        }

        for (int i=0; i< temp.length; i++) {
            arr[i] = temp[i];
        }

        for (int i= temp.length; i<n; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] moveZeroesToEnd(int[] arr) {
        int n = arr.length;
        int j=-1;
        for (int i=0; i<n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        if (j ==-1) return arr;

        for (int i=j+1; i<n; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
        return arr;
    }

    static int linearSearch(int[] arr, int k) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }

    static ArrayList<Integer> union(int[] arr1, int[] arr2, int n, int m) {
//        int n = arr1.length;
//        int m = arr2.length;

        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i < m; i++) {
            set.add(arr2[i]);
        }

        for(int element : set) {
            list.add(element);
        }
        return list;
    }

    static ArrayList<Integer> unionv2(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();

        // pointers
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (list.size() == 0 || list.get(list.size()-1) != arr1[i]) {   // Case 1 and 2
                    list.add(arr1[i]);
                }
                i++;
            }
            else {
                if (list.size() == 0 || list.get(list.size()-1) != arr2[j]) {   // Case 3
                    list.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n) {     // If any element left in arr1
            if (list.get(list.size()-1) != arr1[i]) {
                list.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {     // If any element left in arr2
            if (list.get(list.size()-1) != arr2[j]) {
                list.add(arr2[j]);
            }
            j++;
        }
        return list;
    }

    static ArrayList<Integer> intersect(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] isVisited = new int[m];

        Arrays.fill(isVisited, 0);

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr1[i] == arr2[j] && isVisited[j] == 0) {
                    list.add(arr1[i]);
                    isVisited[j] = 1;
                    break;
                }
                if (arr1[i] < arr2[j]) break;
            }
        }
        return list;
    }

    static ArrayList<Integer> intersection(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0, j=0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            }
            else {
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }

    static int missing(int[] arr, int n) {
//        int n = arr.length;

        for (int i=0; i<n; i++) {
            if (arr[i] != i+1) {
                return i+1;
            }
        }
        return 0;
    }

    static int missingv2(int[] arr, int n) {
        int[] hash = new int[n+1];

        Arrays.fill(hash, 0);

        for (int i=0; i<n-1; i++) {
            hash[arr[i]] = 1;
        }

        for (int i=1; i<=hash.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    static int missingv3(int[] arr, int n) {
        int sum = 0;

        for (int i=0; i<n-1; i++) {
            sum += arr[i];
        }
        return n*(n+1)/2 - sum;
    }

    static int missingv4(int[] arr, int n) {
        int xor = 0;
//        for (int i=1; i<=n; i++) {
//            xor = xor ^ i;
//        }

        int xor2 = 0;
        for (int i=0; i<n-1; i++) {
            xor2 = xor2 ^ arr[i];
            xor = xor ^ (i+1);
            xor = xor ^ n;
        }

        return xor ^ xor2;
    }

    static int conOne(int[] arr) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
            else {
                count = 0;
            }
        }
        return count;
    }

    static int getSingleElement(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            int num = arr[i];
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if (num == arr[j]) {
                    cnt++;
                }
            }
            if (cnt == 1) {
                return num;
            }
        }
        return -1;
    }

    static int getSingleElementv2(int[] arr) {
        int n = arr.length;

        int maxi = 0;
        for (int i=0; i<n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int[] hash = new int[maxi+1];
        for (int i=0; i<n; i++) {
            hash[arr[i]]++;
        }

        for (int i=0; i<n; i++) {
            if (hash[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    static Integer getSingleElementv3(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int elements : arr) {
            if (map.containsKey(elements)) {
                map.put(elements, map.get(elements) + 1);
            }
            else {
                map.put(elements, 1);
            }
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }
        return -1;
    }

    static int getSingleElementv4(int[] arr) {
        int xor = 0;
        int n = arr.length;

        for (int i=0; i<n; i++) {
            xor = xor ^ arr[i];

        }
        return xor;
    }

    static int length(int[] arr, int K) {
        int n = arr.length;
        int length = 0;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) {
                    sum+= arr[k];
                    if (sum == K) {
                        return Math.max(length, j-i+1);
                    }
                }
            }
        }
        return -1;
    }

    static int lengthv2(int[] arr, int K) {
        int n = arr.length;
        int length = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == K) {
                    return Math.max(length, j - i + 1);
                }
            }
        }
        return -1;
    }

    static int lengthv3(int[] arr, int K) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i=0; i<n; i++) {
            sum += arr[i];

            if (sum == K) {
                maxLen = Math.max(maxLen, i+1);
            }

            int rem = sum - K;

            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(len, maxLen);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    static int lengthv4(int[] arr, int K) {
        int n = arr.length;
        int i=0;
        int j=0;
        int sum = arr[0];
        int maxLen = 0;

        while(j < n) {
            while (i <= j && sum > K) {
                sum -= arr[i];
                i++;
            }
            if (sum == K) {
                maxLen = Math.max(maxLen, j-i+1);
            }
            j++;
            if (j < n) sum += arr[j];
        }
        return maxLen;
    }

    static boolean twoSum(int[] arr, int target) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                sum = arr[i] + arr[j];
                if (sum == target) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[] twoSumv2(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (map.containsKey(moreNeeded)) {
                return new int[]{map.get(moreNeeded), i};
            }
            else {
                map.put(num, i);
            }

        }
        return new int[]{-1, -1};
    }

    static boolean twoSumv3(int[] arr, int target) {
        int i=0;
        int j=arr.length-1;
        int sum = 0;

        while (i < j) {
            sum = arr[i] + arr[j];
            if (sum == target) {
                return true;
            }
            else if (sum < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }

    static void sort012(int[] arr, int n) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] == 0) count1++;
            else if (arr[i] == 1) count2++;
            else count3++;
        }

        for (int i=0; i<count1; i++) {
            arr[i] = 0;
        }
        for (int i=count2; i<count2 + count3; i++) {
            arr[i] = 1;
        }
        for (int i=count2+count3; i<n; i++) {
            arr[i] = 2;
        }
    }

    static void sort012v2(int[] arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    static int majority(int[] arr, int n) {
        for (int i=0; i<n; i++) {
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if (arr[i] == arr[j]) cnt++;
            }
            if (cnt > n/2) return arr[i];
        }
        return -1;
    }

    static int majorityv2(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            int num = arr[i];

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > n/2) {
                return it.getKey();
            }
        }
        return -1;
    }

    static int majorityv3(int[] arr, int n) {
        int num = arr[0];
        int count = 1;

        for (int i=1; i<n; i++) {
            if (num == arr[i]) {
                count++;
            }
            else {
                count--;
            }

            if (count == 0) {
                num = arr[i];
                count++;
            }
        }

        int count2 = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] == num) count2++;
            if (count2 > n/2) return arr[i];
        }
        return -1;
    }

    static int maxiSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i=0; i<n; i++) {
            int start = 0;
            if (sum == 0) start = i;
           sum += arr[i];


           if (sum > maxSum) {
               maxSum = Math.max(maxSum, sum);
               ansStart = start;
               ansEnd = i;
           }

           if (sum < 0) {
               sum = 0;
           }
        }
        //printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
        System.out.println("The maximum sum is " + maxSum);
        return maxSum;
    }

    static int stockBuyAndSell(int[] arr, int n) {
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[i] - arr[j] > max) {
                    max = arr[i] - arr[j];
                }
            }
        }
        return max;
    }

    static int stockBuyAndSellv2(int[] arr, int n) {
        int[] temp = new int[n];

        temp[n-1] = arr[n-1];

        for (int i=n-2; i>=0; i--) {
            temp[i] = Math.max(arr[i], temp[i+1]);
        }

        int max=0;
        int j=0;
        for (int i=0; i<n; i++) {
            if (temp[j] - arr[i] > max) {
                max = temp[i]-arr[i];
            }
        }
        return max;
    }

    static int stockBuyAndSellv3(int[] arr, int n) {
        int maxProfit = 0;
        int minSoFar = arr[0];

        for (int i=0; i<n; i++) {
            minSoFar = Math.min(arr[i], minSoFar);
            int profit = arr[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    static int[] rearrange(int[] arr, int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            }
            else {
                neg.add(arr[i]);
            }
        }

        for (int i=0; i<n/2; i++) {
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }
        return arr;
    }

    static int[] rearrangev2(int[] arr, int n) {
        int pos = 0;
        int neg = 1;
        int[] temp = new int[n];

        for (int i=0; i<n; i++) {
            if (arr[i] > 0) {
                temp[pos] = arr[i];
                pos+=2;
            }
            else {
                temp[neg] = arr[i];
                neg+=2;
            }
        }
        return temp;
    }

    static int[] rearrangev3(int[] arr, int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            }
            else {
                neg.add(arr[i]);
            }
        }

        if (pos.size() > neg.size()) {
            for (int i=0; i<neg.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i=neg.size(); i<pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        }
        else {
            for (int i=0; i<pos.size(); i++) {
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i=pos.size(); i<neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }


    static void nextPermutation(int[] arr) {
        int n = arr.length;
        int idx = -1;
        for (int i=n-2; i>=0; i--) {
            if (arr[i] < arr[i+1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(arr, 0, n-1);
            return;
        }

        for (int i=n-1; i>idx; i--) {
            if (arr[i] > arr[idx]) {
                swap(arr, i, idx);
                break;
            }
        }
        reverse(arr, idx+1, n-1);
    }

    static ArrayList<Integer> leaders(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            boolean leaders = true;
            for (int j=i+1; j<n; j++) {
                if (arr[j]>arr[i]) {
                    leaders = false;
                    break;
                }
            }
            if (leaders) {
                ans.add(arr[i]);
            }

        }
        return ans;
    }

    static ArrayList<Integer> leadersv2(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;

        for (int i=n-1; i>=0; i--) {
            if (arr[i] > maxi) {
                ans.add(arr[i]);
            }
            maxi = Math.max(arr[i], maxi);
        }
        return ans;
    }

    static int lcs(int[] arr, int n) {
        int longest = 1;

        for (int i=0; i<n; i++) {
            int curr = arr[i];
            int count = 1;
            while (contains(arr, curr+1)) {
                curr++;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    static boolean contains(int[] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    static int lcsv2(int[] arr, int n) {
        int cntCurr = 0;
        int longest = 1;
        int lastSmaller = Integer.MIN_VALUE;

        Arrays.sort(arr);
        for (int i=0; i<n; i++) {
            if (arr[i] - 1 == lastSmaller) {
                cntCurr++;
                lastSmaller = arr[i];
            }
            else if (arr[i] - 1 != lastSmaller) {
                cntCurr = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(cntCurr, longest);
        }
        return longest;
    }

    static int lcsv3(int[] arr, int n) {
        int longest = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int in : arr) {
            set.add(in);
        }

        for (int i=0; i<set.size(); i++) {
            if (!set.contains(arr[i]-1)) {
                int curr = arr[i];
                int count = 1;

                while (set.contains(curr+1)) {
                    curr++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 1, 3, 2, 4};
        int n = arr.length;
        int ans = lcsv3(arr, n);
        System.out.println(ans);
    }
}