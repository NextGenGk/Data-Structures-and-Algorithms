package Patterns;

public class Pattern_21 {

    static void pattern21(int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == n-1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern21(4);
    }
}

/*

Note : Only fill the stars in the boundary


****
*  *
*  *
****


 */