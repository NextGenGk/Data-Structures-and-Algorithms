package Arrays;

import java.util.HashMap;

public class Single_Number {

    // Method 1 - Brute Force (Using Linear Search)
    // Time - O(N * N), Space - O(1)
//    static int singleNumber(int[] arr, int n) {
//        for (int i=0; i<n; i++) {
//            int count = 0;
//            for (int j=0; j<n; j++) {
//                if (arr[i] == arr[j]) {
//                    count++;
//                }
//            }
//            if (count == 1) {
//                return arr[i];
//            }
//        }
//        return 0;
//    }

    // Method 2 - Better Solution (Using HashMap)
    // Time - O(2N), Space - O(N)
//    static int singleNumber(int[] arr, int n) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i=0; i<n; i++) {
//            if (map.containsKey(arr[i])) {
//                map.put(arr[i], map.get(arr[i]) + 1);
//            }
//            else {
//                map.put(arr[i], 1);
//            }
//        }
//
//        for (int key : map.keySet()) {
//            if (map.get(key) == 1) {
//                return key;
//            }
//        }
//        return 0;
//    }

    // Method 3 - Better Solution (Using HashMap)
    // Time - O(N), Space - O(N)
//    static int singleNumber(int[] arr, int n) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int i=0; i<n; i++) {
//            if (map.containsKey(arr[i])) {
//                map.remove(arr[i]);
//            }
//            else {
//                map.put(arr[i], 1);
//            }
//        }
//
//        for (int key : map.keySet()) {
//            return key;
//        }
//        return 0;
//    }

    // Method 4 - Best Solution (Using XOR)
    // Time - O(N), Space - O(1)
    static int singleNumber(int[] arr, int n) {
        int xor = 0;

        for (int i=0; i<n; i++) {
            xor ^= arr[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        int n = arr.length;

        int result = singleNumber(arr, n);
        System.out.println(result);
    }
}

// Output:
// 4

// Algorithm: Brute Force (Using Linear Search)
/*
1. Take 2 for loops.
2. Outer for loop will run from 0 to n-1.
3. Inner for loop will run from 0 to n-1.
4. Take a variable count and initialize it to 0.
5. If arr[i] == arr[j], then increment count.
6. If count == 1, then return arr[i].
7. If no such element is found, then return 0.
 */

// Algorithm: Better Solution (Using HashMap)
/*
1. Take a HashMap.
2. Run a for loop from 0 to n-1.
3. If map contains arr[i], then increment its value by 1.
4. Else, put arr[i] in the map with value 1.
5. Run a for loop for all the keys in the map.
6. If map.get(key) == 1, then return key.
7. If no such element is found, then return 0.
 */

// Algorithm: Better Solution (Using HashMap)
/*
1. Take a HashMap.
2. Run a for loop from 0 to n-1.
3. If map contains arr[i], then remove it.
4. Else, put arr[i] in the map with value 1.
5. Run a for loop for all the keys in the map.
6. Return key.
 */

// Algorithm: Best Solution (Using XOR)
/*
1. Take a variable xor and initialize it to 0.
2. Run a for loop from 0 to n-1.
3. xor = xor ^ arr[i].
4. Return xor.
 */

// Striver - (Video Link) https://youtu.be/bYWLJb3vCWY