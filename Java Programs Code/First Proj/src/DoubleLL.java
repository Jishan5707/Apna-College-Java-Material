public class DoubleLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return;
    }

    public void printll() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println();
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("DLL is emoty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void reverseLL() {
        Node previous = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = previous;
            curr.prev = next;
            previous = curr;
            curr = next;
        }
        head = previous;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addfirst(3);
        dll.addfirst(2);
        dll.addfirst(1);
        dll.printll();
        // System.out.println(dll.size);

        // dll.removeFirst();
        // dll.printll();
        // System.out.println(dll.size);
        dll.reverseLL();
        dll.printll();

    }

}
