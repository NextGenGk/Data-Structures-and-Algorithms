package Patterns;

public class Pattern_19 {

    static void pattern20(int n) {
        int inIs = 0;
        for (int i=0; i<n; i++) {
            // stars
            for (int j=1; j<=n-i; j++) {
                System.out.print("*");
            }
            for (int j=0; j<inIs; j++) {
                System.out.print(" ");
            }
            for (int j=1; j<=n-i; j++) {
                System.out.print("*");
            }
            inIs += 2;
            System.out.println();
        }

        inIs = 2*n-2;
        for (int i=1; i<=n; i++) {
            // stars
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            for (int j=0; j<inIs; j++) {
                System.out.print(" ");
            }
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            inIs -= 2;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern20(5);
    }
}

/*


 **********
 ****  ****
 ***    ***
 **      **
 *        *
 *        *
 **      **
 ***    ***
 ****  ****
 **********

 */