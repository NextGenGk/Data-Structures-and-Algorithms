package Patterns;

public class Pattern_3 {

    static void pattern3(int n) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern3(5);
    }
}

/*


1
1 2
1 2 3
1 2 3 4
1 2 3 4 5


 */