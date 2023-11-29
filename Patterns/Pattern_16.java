package Patterns;

public class Pattern_16 {

    static void pattern16(int n) {
        char character = 'A';
        for (int i=1; i<=n; i++) {
            for (char ch=character; ch<(character + i); ch++) {
                System.out.print(character);
            }
            System.out.println();
            character = (char) (character + 1);
        }
    }

    public static void main(String[] args) {
        pattern16(5);
    }
}

/*


A
BB
CCC
DDDD
EEEEE


 */
