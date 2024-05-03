import java.util.*;

public class String_2D {

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startColm = 0;
        int endRow = matrix.length - 1;
        int endColm = matrix[0].length - 1;

        while (startRow <= endRow && startColm <= endColm) {
            // top here row is fixed startrow
            for (int j = startColm; j <= endColm; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // Right here colm is fixed endcolm
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endColm] + " ");
            }

            // Bottom here end row is fixed endRow
            for (int j = endColm - 1; j <= startColm; j--) {
                if (startRow == endRow) {
                    break;
                } // this is special case condition where nxn matrix n is odd the
                  // middle element is not repeated twice
                System.out.print(matrix[endRow][j] + " ");
            }

            // Left here startcolm is fixed startColm
            for (int i = endRow + 1; i <= startRow - 1; i--) {
                if (startColm == endColm) {
                    break;
                }
                System.out.print(matrix[i][startColm] + " ");
            }
            startColm++;
            endColm--;
            startRow++;
            endRow--;
        }

    }

    public static int DiagonalSum(int matrix[][]) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
            if (i != n - i - 1) {
                sum += matrix[i][n - i - 1];
            }
        }
        return sum;
    }

    public static boolean StaircaseSearch(int matrix[][], int key) {
        // top right element is row = 0 column = matrix[0].length-1
        int row = 0;
        int colm = matrix[0].length - 1;

        while (row < matrix.length && colm >= 0) {
            if (key == matrix[row][colm]) {
                System.out.println("Key found at (" + row + "," + colm + ")");
                return true;
            } else if (key < matrix[row][colm]) {
                colm--;
            } else {
                row++;
            }
        }
        System.out.println("Key not found!");
        return false;
    }

    public static void main(String[] args) {

        // int matrix[][] = new int[3][3]; // 3*3 matrix is created
        Scanner sc = new Scanner(System.in);
        int matrix[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 }, // this is the 4x4 matrix
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        // printSpiral(matrix); //not working properly
        // System.out.println(DiagonalSum(matrix)); // Working

        // Staircase searching
        int key = 33;

        StaircaseSearch(matrix, key); // Working

    }
}