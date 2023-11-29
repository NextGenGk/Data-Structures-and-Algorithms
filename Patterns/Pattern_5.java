package Patterns;

public class Pattern_5 {

    static void pattern5(int n) {
        for (int i=n; i>0; i--) {
            for (int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern5(5);
    }
}

/*


 * * * * *
 * * * *
 * * *
 * *
 *


 */