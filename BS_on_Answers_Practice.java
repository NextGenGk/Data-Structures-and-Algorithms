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
}
