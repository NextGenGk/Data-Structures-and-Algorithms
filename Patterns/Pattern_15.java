package Patterns;

public class Pattern_15 {

    static void pattern15(int n) {
        for (int i=0; i<n; i++) {
            for (char ch='A'; ch<=('A' + (n-i-1)); ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern15(5);
    }
}

/*


ABCDE
ABCD
ABC
AB
A


 */