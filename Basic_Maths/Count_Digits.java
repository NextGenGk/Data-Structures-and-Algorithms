package Basic_Maths;

class Count_Digits {

    // Optimal Approach
    static int count_Digits (int num) {
        // int count = 0;
        while(num != 0) {
            int lastDigit = num % 10;
            System.out.println(lastDigit);
            // count++;
            num = num / 10;
        }
        return 0;
        // return count;
    }

    // Main Function
    public static void main(String[] args) {
        int result = count_Digits(778989);
        System.out.println(result);
    }
}

