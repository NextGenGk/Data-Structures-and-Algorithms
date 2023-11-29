package Patterns;

public class Pattern_10 {

    static void pattern10(int n) {
        for (int i=0; i<=2*n-1; i++) {
            int stars = i;
            if (i > n) stars = ((2*n) - i);
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern10(5);
    }
}

/*


 *
 * *
 * * *
 * * * *
 * * * * *
 * * * *
 * * *
 * *
 *


 */