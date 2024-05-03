import java.util.*;

public class Queue_Question {

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void firstNonRep(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            freq[curr - 'a']++;
            q.add(curr);
            while (!q.isEmpty()) {
                if (freq[q.peek() - 'a'] == 1) {
                    System.out.print(q.peek() + " ");
                    break;
                } else {
                    q.remove();
                    if (q.isEmpty()) {
                        System.out.print("-1" + " ");
                    }
                }
            }
        }
    }

    // public static void reverseQ(Queue<Integer> q) {

    // Stack<Integer> s = new Stack<>();
    // while (!q.isEmpty()) {
    // s.push(q.remove());

    // }

    // while (!s.isEmpty()) {
    // q.add(s.pop());
    // }

    // while (!q.isEmpty()) {
    // System.out.print(q.remove() + " ");
    // }
    // }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println(q);

        // interLeave(q);
        // while (!q.isEmpty()) {
        // System.out.print(q.remove() + " ");
        // }

        // String str = "aabccxb";
        // firstNonRep(str);
        // reverseQ(q);
    }
}
