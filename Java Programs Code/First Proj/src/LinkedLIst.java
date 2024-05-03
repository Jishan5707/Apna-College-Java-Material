public class LinkedLIst {

    public static class Node {
        int data;
        Node next;

        // this is the constructor for node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // method to add node at first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        }

        newNode.next = head;

        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLL() {
        Node temp = head;
        if (head == null) {
            System.out.println("LL is empty");
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) { // Two corner cases
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            return val;
        }
        Node prev = head;
        for (int i = 1; i < size - 1; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int irsSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void delNthFromEnd(int n) {
        int sz = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        // is head to be deleted
        if (sz == n) {
            head = head.next;
            return;
        }
        int i = 1;
        Node prev = head;
        while (i < sz - n) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }
        return slow;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step 1 find mid
        Node midNode = findMid(head);

        // step 2 reverse the half list
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // step 3 compare left and right
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true; // cycle existx
            }
        }
        return false; // Cycle doen't exist
    }

    public void removeCycle() {
        // detect cycle

        Node slow = head;
        Node fast = head;
        boolean exist = false; // to know if cycle exist or not
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                exist = true;
                break;
            }
        }

        if (exist == false) {
            return;
        }

        // find meetng point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast; // prev will point at fast ka previous
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle
        prev.next = null;
    }

    private Node getmid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next; // this is our required head of merged list
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getmid(head);

        // merge sort for left and right
        Node rightHead = mid.next;
        mid.next = null;
        Node newleft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // do merging part
        return merge(newleft, newRight);
    }

    public void zigZag() {
        // find mid of the list
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow; // mid node

        // reverse the right part of the list
        Node prev = null;
        Node curr = mid.next;
        Node next;
        mid.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL;
        Node nextR;

        // alternating arrangement of the nodes
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
        return;
    }

    public static void main(String[] args) {
        LinkedLIst ll = new LinkedLIst();
        // ll.addFirst(2);
        // ll.addFirst(1);

        // ll.addLast(3);
        // ll.addLast(4);
        // // LL till now created is 2-1-3-4

        // ll.add(2, 9);
        // ll.printLL();
        // System.out.println(ll.size);
        // // ll.removeFirst();
        // // ll.printLL();
        // // System.out.println(ll.size);

        // ll.removeLast();
        // ll.printLL();
        // System.out.println(ll.size);

        // System.out.println(ll.irsSearch(9));
        // ll.reverse();
        // ll.printLL();
        // ll.delNthFromEnd(3);
        // ll.printLL();

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.addLast(1);
        // ll.printLL();

        // System.out.println(ll.checkPalindrome());
        // System.out.println(ll.isCycle());
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = head.next;

        // // 1->2->3->4->2
        // //
        // System.out.println(ll.isCycle());

        // ll.removeCycle();

        // System.out.println(ll.isCycle());

        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.printLL();
        head = ll.mergeSort(head);
        ll.printLL();
        ll.zigZag();
        ll.printLL();
    }
}
