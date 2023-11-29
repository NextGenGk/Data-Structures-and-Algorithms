package Patterns;

public class Pattern_8 {

    static void pattern8(int n) {
        for (int i=0; i<n; i++) {
            // for printing space
            for (int j=0; j<i; j++) {
                System.out.print(" ");
            }
            for (int k=0; k<(2*n -(2*i+1)); k++) {
                System.out.print("*");
            }
            for (int l=0; l<i; l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern8(5);
    }
}


/*


 *********
 *******
 *****
 ***
 *


 */