import java.util.*;

public class Queue_LL {

    // public static class Node {
    // int data;
    // Node next;

    // public Node(int data) {
    // this.data = data;
    // this.next = null;
    // }
    // }

    // public static class Queue {

    // static Node head = null;
    // static Node tail = null;

    // public static boolean isEmpty() {
    // return (head == null) && (tail == null);
    // }

    // public static void add(int data) {
    // Node newNode = new Node(data);
    // if (head == null) {
    // head = tail = newNode;
    // }
    // tail.next = newNode;
    // tail = newNode;
    // }

    // public static int remove() {
    // if (isEmpty()) {
    // System.out.println("Queue is empty");
    // return -1;
    // }
    // int result = head.data;
    // if (head == tail) {
    // head = tail = null;
    // } else {
    // head = head.next;
    // }
    // return result;
    // }

    // public static int peek()
    // return head.data;
    // }
    // }

    /*
     * public static class Queue {
     * static Stack<Integer> s1 = new Stack<>();
     * static Stack<Integer> s2 = new Stack<>();
     * 
     * public boolean isEmpty() {
     * return s1.isEmpty();
     * }
     * 
     * public static void add(int data) {
     * while (!s1.isEmpty()) {
     * s2.push(s1.pop());
     * }
     * 
     * s1.push(data);
     * 
     * while (!s2.isEmpty()) {
     * s1.push(s2.pop());
     * }
     * }
     * 
     * public static int remove() {
     * if (s1.isEmpty()) {
     * System.out.println("Queue is empty");
     * return -1;
     * } else {
     * return s1.pop();
     * }
     * }
     * 
     * public static int peek() {
     * if (s1.isEmpty()) {
     * System.out.println("Queue is empty");
     * return -1;
     * } else {
     * return s1.peek();
     * }
     * }
     * 
     * }
     * 
     * public static void main(String[] args) {
     * // Queue<Integer> q = new ArrayDeque<>();
     * // // Queue q = new Queue();
     * // q.add(1);
     * // q.add(2);
     * // q.add(3);
     * // while (!q.isEmpty()) {
     * // System.out.print(q.peek() + " ");
     * // q.remove();
     * // }
     * 
     * Queue q = new Queue();
     * q.add(1);
     * q.add(2);
     * q.add(3);
     * 
     * while (!q.isEmpty())
     * System.out.println(q.remove());
     * }
     * }
     * 
     */

    public static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
