package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Majority_Element_Nby3 {

    // Method 1 - Brute Force
    // Time - O(N^2), Space - O(1)
//    static List<Integer> majorityElement(int[] arr, int n) {
//        List<Integer> ans = new ArrayList<>();
//
//        for (int i=0; i<n; i++) {
//            if (ans.contains(arr[i])) {
//                continue;
//            }
//            int count = 0;
//            for (int j=0; j<n; j++) {
//                if (arr[i] == arr[j]) {
//                    count++;
//                }
//            }
//            if (count > n/3) {
//                ans.add(arr[i]);
//            }
////            if (ans.size() == 2) {
////                break;
////            }
//        }
//        return ans;
//    }

    // Method 2 - Better Solution
    // Time - O(N*logN) + O(N), where N = size of the given array.
    // Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN).
    // If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).
    // Space - O(N), because using HashMap
//    static List<Integer> majorityElement1(int[] arr, int n) {
//        List<Integer> ans = new ArrayList<>();
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i=0; i<n; i++) {
//            if (map.containsKey(arr[i])) {
//                map.put(arr[i], map.get(arr[i]) + 1);
//            } else {
//                map.put(arr[i], 1);
//            }
//        }
//
//        for (int key : map.keySet()) {
//            if (map.get(key) > n/3) {
//                ans.add(key);
//            }
//        }
//        return ans;
//    }

    // Method 3 : Optimal Solution (Using Moore's Voting Algorithm)
    // Time - O(N) + O(N), where N = size of the given array.
    // Reason: The first O(N) is to calculate the counts and find the expected majority elements.
    // The second one is to check if the calculated elements are the majority ones or not.
    // Space - O(1), because we are not using any extra space.
    static List<Integer> majorityElement2(int[] arr, int n) {
        int count1 = 0, ele1 = Integer.MIN_VALUE;
        int count2 = 0, ele2 = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            if (count1 == 0 && arr[i] != ele2) {
                count1 = 1;
                ele1 = arr[i];
            }
            else if (count2 == 0 && arr[i] != ele1) {
                count2 = 1;
                ele2 = arr[i];
            }
            else if (ele1 == arr[i]) count1++;
            else if (ele2 == arr[i]) count2++;
            else {
                count1--;
                count2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        int cnt1 = 0; int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele1) cnt1++;
            if (arr[i] == ele2) cnt2++;
        }

        if (cnt1 > n/3) ls.add(ele1);
        if (cnt2 >= n/3) ls.add(ele2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return ls;
    }

    // Main Function
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 2, 2, 2};
        int n = arr.length;

        System.out.println(majorityElement2(arr, n));
    }
}

// Output-
// [1, 2]

// Algorithm: Brute Force (Using 3 for Loops)
/*
1. Create an empty list ans which stores the answer
2. Run a loop from i=0 to n-1
    2.1 Run a loop from j=i to n-1
        2.1.1 If arr[i] == arr[j], then increment count
    2.2 If count > n/3, then add arr[i] to ans
3. Return ans
 */

// Algorithm: Better Solution (Using HashMap)
/*
1. Create an empty list ans which stores the answer
2. Create a HashMap map which stores the frequency of each element
3. Run a loop from i=0 to n-1
    3.1 If map contains arr[i], then increment the frequency of arr[i] by 1
    3.2 Else, put arr[i] in the map with frequency 1
4. Run a loop for each key in map
    4.1 If map.get(key) > n/3, then add key to ans
5. Return ans
 */

// Algorithm: Optimal Solution (Using Moore's Voting Algorithm)
/*
1. Create two variables count1 and count2 and initialize them with 0
2. Create two variables ele1 and ele2 and initialize them with Integer.MIN_VALUE
3. Run a loop from i=0 to n-1
    3.1 If count1 == 0 and arr[i] != ele2, then set count1 = 1 and ele1 = arr[i]
    3.2 Else if count2 == 0 and arr[i] != ele1, then set count2 = 1 and ele2 = arr[i]
    3.3 Else if ele1 == arr[i], then increment count1 by 1
    3.4 Else if ele2 == arr[i], then increment count2 by 1
    3.5 Else, decrement count1 and count2 by 1
4. Create an empty list ls which stores the answer
5. Run a loop from i=0 to n-1
    5.1 If arr[i] == ele1, then increment cnt1 by 1
    5.2 If arr[i] == ele2, then increment cnt2 by 1
6. If cnt1 > n/3, then add ele1 to ls
7. If cnt2 > n/3, then add ele2 to ls
8. Return ls
 */

// Striver : (Video Explanation) https://youtu.be/vwZj1K0e9U8