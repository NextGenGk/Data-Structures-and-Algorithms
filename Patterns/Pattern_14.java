package Patterns;

public class Pattern_14 {

    static void pattern14(int n) {
        for (int i=0; i<n; i++) {
            for (char ch='A'; ch<=('A' + i); ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pattern14(5);
    }
}

/*
If we observe on the output screen we got our first value is 97 and our last value is 122,
which shows the range of lowercase alphabet (a to z) is 97 to 122.


A
AB
ABC
ABCD
ABCDE


 */