import java.util.*;

public class BST {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }
        if (root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public static Node inorderSucc(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.data < val) {
            root.right = delete(root.right, val);
        }
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else { // the val is found
            // case - 1 leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case - 2 one child
            if (root.left == null) {
                return root.right; // hum root ke parent ko return kar rahe hai.
            } else if (root.right == null) { // jisse root delete ho jata hai
                return root.left;
            }

            // case - 3 two children // find inorder successor

            Node IS = inorderSucc(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printrootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println();
        }
        printrootToLeaf(root.left, path);
        printrootToLeaf(root.right, path);
        path.remove(path.size() - 1);
    }

    // public static boolean isBST(Node root, Node min, Node max) {
    // if (root == null) {
    // return true;
    // }
    // if (min != null && root.data < min.data) {
    // return false;
    // } else if (max != null && root.data > max.data) {
    // return false;
    // }
    // return isBST(root.left, min, root) && isBST(root.right, root, max);
    // }

    public static void mirrorBST(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBST(root.left);
        mirrorBST(root.right);
    }

    public static Node mirrorBST2(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmirrored = mirrorBST2(root.left);
        Node rightmirrored = mirrorBST2(root.right);
        root.left = rightmirrored;
        root.right = leftmirrored;
        return root;
    }

    public static Node createBST2(Node root, int arr[], int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        root = new Node(arr[mid]);
        root.left = createBST2(root, arr, st, mid - 1);
        root.right = createBST2(root, arr, mid + 1, end);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(Node root, ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        root = new Node(inorder.get(mid));
        root.left = createBST(root, inorder, st, mid - 1);
        root.right = createBST(root, inorder, mid + 1, end);
        return root;
    }

    public static Node balancedBST(Node root) {
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // sorted inorder to balanced bst
        root = createBST(root, inorder, 0, inorder.size() - 1);
        return root;
    }

    public class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    public static int maxBST = 0;

    // public static Info largestBST(Node root) {

    // if (root == null) {
    // return new Info(true, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    // }
    // Info leftInfo = largestBST(root.left);
    // Info rightInfo = largestBST(root.right);
    // int size = leftInfo.size + rightInfo.size + 1;
    // int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
    // int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

    // if (root.data < leftInfo.max || root.data > rightInfo.min) {
    // return new Info(false, size, min, max);
    // }

    // if (leftInfo.isBST && rightInfo.isBST) {
    // maxBST = Math.max(maxBST, size);
    // return new Info(true, size, min, max);
    // }

    // return new Info(false, size, min, max);
    // }

    public static Node createBST2(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST2(inorder, st, mid - 1);
        root.right = createBST2(inorder, mid + 1, end);
        return root;
    }

    public static Node mergeBSTs(Node root1, Node roo2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root1, arr2);

        ArrayList<Integer> finalarr = new ArrayList<>();
        // merging the two arrays
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalarr.add(arr1.get(i));
                i++;
            } else {
                finalarr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            finalarr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            finalarr.add(arr2.get(j));
            j++;
        }

        // sorted arraylist -> BST conversion

        return createBST2(finalarr, 0, finalarr.size() - 1);
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11 };
        Node root = null;

        // for (int i = 0; i < values.length; i++) {
        // root = insert(root, values[i]);
        // }
        // inorder(root);

        // System.out.println();
        // for (int i = 1; i <= 10; i++) {
        // root = insert(root, i);
        // }
        // inorder(root);
        // System.out.println();
        // // System.out.println(search(root, 6));
        // delete(root, 10);
        // inorder(root);
        // System.out.println();
        // printInRange(root, 5, 12);
        // printrootToLeaf(root, new ArrayList<>());

        // if (isBST(root, null, null)) {
        // System.out.println("valid");
        // } else {
        // System.out.println("Not valid");
        // }
        // inorder(root);
        // mirrorBST(root);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // mirrorBST2(root);
        // inorder(root);

        // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        // root = createBST2(root, arr, 0, arr.length - 1);

        // Node root2 = new Node(8);
        // root2.left = new Node(6);
        // root2.left.left = new Node(5);
        // root2.left.left.left = new Node(3);

        // root2.right = new Node(10);
        // root2.right.right = new Node(11);
        // root2.right.right.right = new Node(12);

        // root2 = balancedBST(root2);
        // preorder(root2);

        // Node root3 = new Node(50);
        // root3.left = new Node(30);
        // root3.left.left = new Node(5);
        // root3.left.right = new Node(20);

        // root3.right = new Node(60);
        // root3.right.left = new Node(45);
        // root3.right.right = new Node(70);
        // root3.right.right.right = new Node(80);
        // root3.right.right.left = new Node(65);

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        root = mergeBSTs(root1, root2);
        inorder(root);
    }
}
