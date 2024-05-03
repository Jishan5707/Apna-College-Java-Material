import java.util.LinkedList;

public class linkedListJCF {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        // Adding the integers
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.addFirst(7);

        // Removing the integers
        ll.removeFirst();
        ll.removeLast();

        // printing the list
        System.out.println(ll);

    }
}
