package WorkingFiles;

public class SortPractice {

    static void sort(int[] arr, int n) {
        for (int i=0; i<n-1; i++) {
            int min = i;
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    static void bubble(int[] arr) {
        boolean swapped = false;
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j+1] < arr[j]) {
                    swap(arr, j+1, j);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    static void bubbleRec(int[] arr, int n) {
        if (n == 1) return;

        boolean swap = false;

        for (int i=0; i<n-1; i++) {
            if (arr[i] > arr[i+1]) {
                swap(arr, i, i+1);
                swap = true;
            }

        }
        if (swap == false) {
            return;
        }

        bubbleRec(arr, n-1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void insertion(int[] arr) {
        int n = arr.length;
        for (int i=1; i<n; i++) {
            int temp  = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    static void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        divide(arr, start, mid);
        divide(arr, mid+1, end);
        conquer(arr, start, mid, end);
    }

    static void conquer(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];

        int idx1 = start;
        int idx2 = mid+1;
        int x = 0;

        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x] = arr[idx1];
                x++;
                idx1++;
            }
            else {
                merged[x] = arr[idx2];
                x++;
                idx2++;
            }
        }

        while (idx1 <= mid) {
            merged[x] = arr[idx1];
            x++;
            idx1++;
        }

        while (idx2 <= end) {
            merged[x] = arr[idx2];
            x++;
            idx2++;
        }

        for (int i=0, j=start; i< merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1; // Start from the element next to pivot
        int j = high;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        // Swap pivot with the element at position j
        swap(arr, low, j);
        return j; // Return the pivot's final position
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

//    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }


    static void printArray2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {7,8,1,3,2};
        quickSort(arr, 0, arr.length-1);
        printArray2(arr);
    }
}
