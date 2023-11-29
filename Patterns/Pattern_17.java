package Patterns;

public class Pattern_17 {

    static void pattern17(int n) {
        for (int i=0; i<n; i++) {
            // spaces
            for (int j=0; j<n-i-1; j++) {
                System.out.print(" ");
            }

            char ch='A';
            int breakpoint = (2*i+1) / 2;
            for (int j=1; j<=2*i+1; j++) {
                System.out.print(ch);
                if (j <= breakpoint) ch++;
                else ch--;
            }

            for (int j=0; j<n-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern17(5);
    }
}

/*
breakpoint = until space (half symmetry at center)
2*0+1 / 2
2*1+1 / 2


    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA


 */