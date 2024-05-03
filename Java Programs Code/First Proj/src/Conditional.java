import java.util.*;

public class Conditional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int age = sc.nextInt();
        // if (age >= 18) {
        // System.out.println("You can vote");

        // } else {
        // System.out.println("You cant vote");

        // }

        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // if (a > b) {
        // System.out.println("A is bigger");
        // } else {
        // System.out.println("B is bigger");

        // Finding if number entered is even or odd
        // int num = sc.nextInt();
        // if (num % 2 == 0) {
        // System.out.println("Number is even");
        // } else {
        // System.out.println("Number is odd");

        // }

        // Income tax calculator

        // int income = sc.nextInt();

        // if (income < 500000) {
        // System.out.println("Your tax is " + 0);

        // } else if (500000 <= income && income < 1000000) {
        // System.out.println("Your tax is " + (income) * 0.2);

        // } else {
        // System.out.println("Your tax is " + income * 0.3);
        // }

        // ternary operators

        // int number = sc.nextInt();

        // String type = (number % 2 == 0) ? "even" : "false";// Ternary operator is
        // used here
        // System.out.println(type);

        // Switch operator

        // int variable = sc.nextInt();
        // switch (variable) {
        // case 1:
        // System.out.println("Samosa");
        // break; // break is used to stop the execution at this position
        // case 2:
        // System.out.println("Burgre");
        // break;
        // case 3:
        // System.out.println("Nothing");
        // break;
        // default:
        // System.out.println("shut up");

        // Topic of loops start hare

        // int input = sc.nextInt();
        // int n = 0;
        // int count = 1;
        // while (count <= input) {
        // n = n + count;
        // count++;

        // }
        // System.out.println(n);

        // Code for reversing of two numbers

        // int n = sc.nextInt();
        // while (n > 0) {
        // int lastDigit = n % 10;
        // System.out.print(lastDigit);

        // n = n / 10;
        // }

        // reversing the number and saving it in the variable
        // int rev = 0;
        // int n = sc.nextInt();
        // while (n > 0) {
        // int lastdigit = n % 10;
        // rev = rev * 10 + lastdigit;
        // n = n / 10;
        // }
        // System.out.println(rev);

        // Do while loop

        // int counter = 1;
        // do {
        // System.out.print("Hello world");
        // counter++;
        // } while (counter <= 10);

        // Keep entering numbers till user enters a multiple of 10

        // do {
        // System.out.print("Enter your number ");
        // int number = sc.nextInt();
        // if (number % 10 == 0) {
        // break;
        // }
        // System.out.println(number);
        // } while (true);

        // Taking nunbers not multiple of 10

        // while (true) {
        // System.out.println("Enter the number");
        // int number = sc.nextInt();

        // if (number % 10 == 0) {
        // System.out.println("Multiple of 10 cannot be printed");
        // continue;
        // }
        // System.out.println(number);

        // Finding if number is Prime or not\

        int number = sc.nextInt();
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(number); i++) { // number-1 or number/2 both are correct
            if (number % i == 0) { // square root of number Math.sqrt(number) can alson be used
                isPrime = false;
            }
        }
        if (isPrime == true) {
            System.out.println("Prime");
        } else {
            System.out.println("Not prime");
        }

    }
}
