import java.security.cert.PKIXBuilderParameters;
import java.util.*;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Functions {

    // Function is defined here //Piblic static (return type) is always used when
    // defining a function
    public static void printHello() {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
    }

    public static void printHellow() {
        System.out.println("Hello World Again");
        System.out.println("Hello World Again");
        System.out.println("Hello World Again");
    }

    public static void printhi() {
        System.out.println("Hi how are you");
        System.out.println("Hi how are you");
        System.out.println("Hi how are you");

    }

    public static void CalSum(int a, int b) {
        int sum = a + b;
        System.out.println("sum is : " + sum);
    }

    // Function to swap two numbers
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a is :" + a);
        System.out.println("b is :" + b);
    }

    // Multiplication of two numbers
    public static int multiply(int a, int b) {
        int product = a * b;
        return product;
    }

    // Factorial of a number
    public static int factorial(int n) {
        int f;
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
        }
        return ans;
    }

    // Finding Binomial_Coefficient nCr
    public static int BinCoeff(int n, int r) {
        int n_fact = factorial(n);
        int r_fact = factorial(r);
        int nmr_fact = factorial(n - r);
        int bino = (n_fact) / (r_fact * nmr_fact);
        return bino;
    }

    // This is the case of Function Overloading
    // Here we have created two functions with same name and different no of
    // parameters
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    // Function overloading using Different types of parameters
    public static int sum1(int c, int d) {
        return c + d;
    }

    public static float sum1(float c, float d) {
        return c + d;
    }

    public static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void PrimeRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Function to convert from binary to decimal number
    public static void BinToDec(int binNum) {
        int power = 0;
        int decimal = 0;
        while (binNum > 0) {
            int lastdigit = binNum % 10;
            decimal = decimal + (lastdigit * (int) (Math.pow(2, power)));// Typecasting is required here
            power++;
            binNum = binNum / 10;
        }
        System.out.println(decimal);
    }

    // Function for decimal to biary
    public static void DecToBin(int dec) {
        int remainder;
        int binary = 0;
        int pow = 0;
        while (dec > 0) {
            remainder = dec % 2;
            binary = binary + remainder * (int) (Math.pow(10, pow));
            pow++;
            dec = dec / 2;
        }
        System.out.println(binary);
    }

    // Function to compute avg of two numbers
    public static void Avg3(int a, int b, int c) {
        System.out.println((a + b + c) / 3);
    }

    // Function to find even or odd
    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Function to reverse a number
    public static int ReverseNo(int n) {
        int nom = 0;
        int lastdigit;
        while (n >= 0) {
            lastdigit = n % 10;
            nom = lastdigit + nom * 10;
            n = n / 10;
        }
        return nom;
    }

    public static boolean isPalindrome(int number) {
        int isReverse = ReverseNo(number);
        if (isReverse == number) {
            System.out.println("YES");
            return true;
        } else {
            return false;
        }
    }

    // Function to Find sum of digits in a number
    public static int SumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            sum = sum + lastDigit;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // int a = 10;
        // int b = 5;
        // swap(a, b);

        // // But actually when the function call is over the actual value of the
        // variables
        // // is displayed we can see that original values are not changed
        // System.out.println("a is :" + a);
        // System.out.println("b is :" + b);

        // int prod = multiply(20, 10);
        // System.out.println("a*b is: " + prod);

        // int factorial = factorial(7);
        // System.out.println(factorial);

        // System.out.println(BinCoeff(5, 2));

        // System.out.println(sum(10, 20));// Function overloading
        // System.out.println(sum(10, 20, 30));

        // System.out.println(sum1(10, 20));// Function overloading
        // System.out.println(sum1(10.5f, 20.5f));

        // System.out.println(isPrime(5));
        // System.out.println(isPrime(10));
        // System.out.println(isPrime(1));
        // System.out.println(isPrime(2));

        // Range of prime numbers
        // PrimeRange(10);

        // BinToDec(101);

        // DecToBin(5);
        // DecToBin(10);
        // DecToBin(4);
        // DecToBin(7);

        // Question are solved from here

        // Avg3(1, 2, 3);
        // System.out.println(isEven(5));
        // System.out.println(isEven(10));

        // ReverseNo(125);
        // System.out.println(isPalindrome(120));

        // System.out.println(SumOfDigits(235));
        DecToBin(125);
        BinToDec(1111101);

    }
}