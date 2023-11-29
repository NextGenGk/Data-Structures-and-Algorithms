package Patterns;

public class Pattern_6 {

    static void pattern5(int n) {
        for (int i=n; i>0; i--) {
            for (int j=1; j<=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern5(5);
    }
}

/*


1 2 3 4 5
1 2 3 4
1 2 3
1 2
1


 */