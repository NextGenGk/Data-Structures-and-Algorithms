package Patterns;

public class Pattern_12 {

    static void pattern12(int n) {
        // initial no. of spaces in row 1.
        int spaces = 2*(n-1);

        // Outer loop for the number of rows.
        for(int i=1;i<=n;i++){

            // for printing numbers in each row
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }

            // for printing spaces in each row
            for(int j = 1;j<=spaces;j++){
                System.out.print(" ");
            }

            // for printing numbers in each row
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }

            // As soon as the numbers for each iteration are printed, we move to the
            // next row and give a line break otherwise all numbers
            // would get printed in 1 line.
            System.out.println();

            // After each iteration nos. increase by 2, thus
            // spaces will decrement by 2.
            spaces-=2;
        }
    }

    public static void main(String[] args) {
        pattern12(5);
    }
}

/*


1        1
12      21
123    321
1234  4321
1234554321


 */