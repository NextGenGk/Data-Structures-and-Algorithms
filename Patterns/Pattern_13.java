package Patterns;

public class Pattern_13 {

    static void pattern13(int n) {
        int start = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print(start + " ");
                start += 1;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern13(5);
    }
}

/*


1
2 3
4 5 6
7 8 9 10
11 12 13 14 15


 */