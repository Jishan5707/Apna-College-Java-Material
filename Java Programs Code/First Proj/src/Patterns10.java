import java.util.*;

public class Patterns10 {

    public static void Hallow_Rectangle(int totRows, int totCols) {

        // outer loop -row
        for (int i = 1; i <= totRows; i++) {

            // Inner loop -column
            for (int j = 1; j <= totCols; j++) {

                // cell--(i,j)

                if (i == 1 || i == totRows || j == 1 || j == totCols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            // After one row is done new line is taken
            System.out.println();
        }
    }

    // Inverted Rotated half Pyramid

    public static void Inverted_Rotated_Pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Inverted_Rotated_Pyramid_Number(int n) {

        // Outer loop of lines
        for (int i = 1; i <= n; i++) {

            // Numbers
            for (int j = 1; j <= n + 1 - i; j++) {
                System.out.print(j);
            }

            // Spaces
            // for (int j = 1; j <= i - 1; j++) {
            // System.out.print(" ");
            // }
            System.out.println();
        }
    }

    public static void FLOYDS_Triangle(int n) {
        int digit = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(digit + " ");
                digit++;
            }
            System.out.println();
        }
    }

    // 0-1 Triangle
    public static void Triangle_01(int n) {
        // Outer loop
        for (int i = 1; i <= n; i++) {

            // inner loop
            for (int j = 1; j <= i; j++) {

                if ((i + j) % 2 == 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    // Butterfly Pattern
    public static void Butterfly_Pattern(int n) {

        // First halhf of pattern
        for (int i = 1; i <= n; i++) {
            // First star is printed
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Spaces are given
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // Second star is printed
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Second half of pattern
        for (int i = n; i >= 1; i--) {
            // First star is printed
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // Spaces are given
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }

            // Second star is printed
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Solid_Rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // Spaces1
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }

            // Spaces2 This part can be ignored insted we can directly write next line
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void Hollow_Rhombus(int n) {

        // Outer loop
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // stars depending on condition
            if (i == 1 || i == n) {
                for (int j = 1; j <= n; j++) {
                    System.out.print("*");
                }
            } else {
                // 1 Star , n-2 Spaces , 1 Star
                System.out.print("*");

                // n-2 Spaces
                for (int j = 1; j <= n - 2; j++) {
                    System.out.print(" ");
                }

                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void Diamond_Pattern(int n) {
        // First Half
        for (int i = 1; i <= n; i++) {

            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Second Half
        for (int i = n; i >= 1; i--) {
            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void Number_Pattern(int n) {

        for (int i = 1; i <= n; i++) {

            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Number
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void Palindrome_Numbers_Pattern(int n) {
        // Outer loop
        for (int i = 1; i <= n; i++) {

            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Numbers Left side
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            // Numbers Right side
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Star pattern
        // for (int line = 1; line <= 4; line++) {
        // for (int star = 1; star <= line; star++) {
        // System.out.print('*');
        // }
        // System.out.println();
        // }

        // // Reverse Star pattern
        // for (int line = 1; line <= 4; line++) {
        // for (int star = 1; star <= 5 - line; star++) {
        // System.out.print('*');
        // }
        // System.out.println();
        // }

        // // Number pattern downwards
        // for (int line = 1; line <= 4; line++) {
        // for (int number = 1; number <= line; number++) {
        // System.out.print(number);
        // }
        // System.out.println();
        // }
        // // Reverse number pattern
        // for (int line = 1; line <= 4; line++) {
        // for (int number = 1; number <= 5 - line; number++) {
        // System.out.print(number);
        // }
        // System.out.println();
        // }

        // // Character pattern of alphabets
        // char chars = 'A';
        // for (int line = 1; line <= 4; line++) {
        // for (int number = 1; number <= line; number++) {
        // System.out.print(chars);// Each time character is printed it is updated to
        // next character
        // chars++;
        // }
        // System.out.println();
        // }

        // // FLOYD'S Triangle pattern
        // int num = 1;
        // for (int line = 1; line <= 4; line++) {
        // for (int number = 1; number <= line; number++) {
        // System.out.print(num);
        // num++;
        // }
        // System.out.println();
        // }

        // Patterns Part 2 Starts from here

        // Hallow_Rectangle(7, 7);
        // Hallow_Rectangle(6, 6);
        // Hallow_Rectangle(5, 5);
        // Hallow_Rectangle(4, 4);
        // Hallow_Rectangle(3, 3);
        // Hallow_Rectangle(2, 2);
        // Hallow_Rectangle(1, 1);

        // Inverted_Rotated_Pyramid(2);
        // Inverted_Rotated_Pyramid(4);
        // Inverted_Rotated_Pyramid(6);
        // Inverted_Rotated_Pyramid(8);
        // Inverted_Rotated_Pyramid(10);

        // Inverted_Rotated_Pyramid_Number(5);
        // Inverted_Rotated_Pyramid_Number(6);

        // FLOYDS_Triangle(5);
        // FLOYDS_Triangle(10);

        // Triangle_01(5);
        // Butterfly_Pattern(4);
        // Butterfly_Pattern(5);
        // Butterfly_Pattern(7);

        // Solid_Rhombus(5);
        // Solid_Rhombus(10);

        // Hollow_Rhombus(5);
        // Hollow_Rhombus(10);

        Diamond_Pattern(4);
        // Diamond_Pattern(7);
        Number_Pattern(5);

        Palindrome_Numbers_Pattern(5);

    }
}
