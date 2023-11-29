package Patterns;

public class Pattern_18 {

    static void  pattern18(int n) {
        for (int i=0; i<n; i++) {
            for (char ch=(char) ('E'- i); ch<='E'; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern18(5);
    }
}

/*


E
D E
C D E
B C D E
A B C D E


 */