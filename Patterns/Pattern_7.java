package Patterns;

public class Pattern_7 {

    static void pattern7(int n) {
        for (int i=0; i<n; i++) {
            // for printing space
            for (int j=0; j<(n-i-1); j++) {
                System.out.print(" ");
            }
            for (int k=0; k<(2*i+1); k++) {
                System.out.print("*");
            }
            for (int l=0; l<(n-i-1); l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern7(5);
    }
}

/*


 *
 ***
 *****
 *******
 *********


 */