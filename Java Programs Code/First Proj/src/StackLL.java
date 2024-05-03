import java.util.Stack;

//make the class of StackLL for implementing it 

// public static class Node {
// int data;
// Node next;

// Node(int data) {
// this.data = data;
// this.next = null;
// }
// }

// static class Stack {
// static Node head = null;

// public static boolean isEmpty() {
// return head == null;
// }

// // push
// public static void push(int data) {
// Node newNode = new Node(data);

// if (isEmpty()) {
// head = newNode;
// return;
// }
// }

// // pop
// public static int pop() {
// if (head == null) {
// return -1;
// }
// int top = head.data;
// head = head.next;
// return top;
// }

// // peek
// public static int peek() {
// if (head == null) {
// return -1;
// }
// return head.data;
// }

// Stack s = new Stack();

public class StackLL {

    public static void pushAtBottom(Stack<Integer> s, int data) { // AMAZON
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) { // here we have pushed all the char in the stack
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString(); // here we are storing the stringbuilder into the string
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);

    }

    public static void stockspan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void nextGreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int GreaterArray[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                GreaterArray[i] = -1;
            } else {
                GreaterArray[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for (int i = 0; i < GreaterArray.length; i++) {
            System.out.print(GreaterArray[i] + " ");
        }
        System.out.println();
    }

    public static boolean isvalidParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // opening characters
            if (ch == '(' || ch == 'a' || ch == 'b' || ch == 'c' || ch == 'd' || ch == '+' || ch == '-') {
                s.push(ch);
            }
            if (ch == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public static void maxArea(int arr[]) {
        int maxarea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        // next smaller right

        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            while (!s.isEmpty() && curr <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            s.pop();
        }
        // empty the stack

        // nexr smaller left
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            while (!s.isEmpty() && curr <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // current area width : j-i-1 nsr[i] - nsl[i] - 1
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currentArea = height * width;
            maxarea = Math.max(currentArea, maxarea);
        }
        System.out.println("Max area in the histogram is " + maxarea);
    }

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // here we have implemented stack using JCF
        // same =methods are implemented using the class of stack imported

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // pushAtBottom(s, 4);
        // printStack(s);
        // String str = "ABCDEF";
        // String result = reverseString(str);
        // System.out.print(result);
        // reverseStack(s);
        // printStack(s);

        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stocks.length];
        // stockspan(stocks, span);
        // printArray(span);
        // int arr[] = { 6, 8, 0, 1, 3 };
        // int GreaterArray[] = new int[arr.length];
        // nextGreater(arr);
        // printArray(GreaterArray);
        // int arr2[] = { 5, 9, 6, 3, 14, 13, 2 };
        // nextGreater(arr2);
        // }

        // String str = "({})[]{{}}";
        // System.out.println(isvalidParenthesis(str));

        // String str = "((a+b))"; // true
        // String str2 = "(a-b)";
        // System.out.println(isDuplicate(str));
        // System.out.println(isDuplicate(str2));

        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(arr);

    }
}
