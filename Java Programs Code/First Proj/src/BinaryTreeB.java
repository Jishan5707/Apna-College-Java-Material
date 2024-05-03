import java.util.*;

public class BinaryTreeB {
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

    public static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int Nodes[]) {
            idx++;
            if (Nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = buildTree(Nodes);
            newNode.right = buildTree(Nodes);
            return newNode;
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

        public static void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh) + 1;
        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int cl = count(root.left);
            int cr = count(root.right);
            return cl + cr + 1;
        }

        public static int countSum(Node root) {
            if (root == null) {
                return 0;
            }
            int csl = countSum(root.left);
            int csr = countSum(root.right);
            return csl + csr + root.data;
        }

        public static int diameter2(Node root) {
            if (root == null) {
                return 0;
            }
            int leftDiameter = diameter2(root.left);
            int leftHeight = height(root.left);

            int rightDiameter = diameter2(root.right);
            int rightHeight = height(root.right);

            int selfDiameter = leftHeight + rightHeight + 1;

            return Math.max(selfDiameter, Math.max(rightDiameter, leftDiameter));
        }

        static class info {
            int diam;
            int ht;

            info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        // did not understood this approach
        // public static info diameter(Node root) {
        // if (root == null) {
        // return new info(0, 0);
        // }
        // info leftinfo = diameter(root.left);
        // info rightinfo = diameter(root.right);

        // int diam = Math.max(Math.max(leftinfo.diam, rightinfo.diam), leftinfo.ht +
        // rightinfo.ht + 1);
        // int ht = Math.max(leftinfo.ht, rightinfo.ht) + 1;
        // return new info(diam, ht);
        // }

        public static boolean isIdentical(Node node, Node subRoot) {
            if (node == null && subRoot == null) {
                return true;
            } else if (node == null || subRoot == null || node.data != subRoot.data) {
                return false;
            }
            if (!isIdentical(node.left, subRoot.left)) {
                return false;
            }
            if (!isIdentical(node.right, subRoot.right)) {
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node root, Node subRoot) {
            if (root == null) {
                return false;
            }
            if (root.data == subRoot.data) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }
            boolean leftAns = isSubtree(root.left, subRoot);
            boolean rightAns = isSubtree(root.right, subRoot);

            // if the subtree either exist in the left OR exist in the right we have to
            // return true
            return leftAns || rightAns;
        }

        public static class Info {
            Node node;
            int hd;

            public Info(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topview(Node root) {
            Queue<Info> q = new LinkedList<>();

            HashMap<Integer, Node> map = new HashMap<>();

            int min = 0;
            int max = 0;
            q.add(new Info(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Info curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) { // first time hd is occuring
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) { // comparing the left and entering in the map
                        q.add(new Info(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) { // comparing the right and entering it in the map
                        q.add(new Info(curr.node.right, curr.hd + 1));
                        max = Math.max(min, curr.hd + 1);
                    }
                }

            }

            for (int i = min; i <= max; i++) { // loop for printing the data
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }

        public static void kLevel(Node root, int k, int level) {
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data + " ");
                return;
            }
            kLevel(root.left, k, level + 1);
            kLevel(root.right, k, level + 1);
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }
            path.add(root);

            if (root.data == n) {
                return true;
            }
            boolean leftFound = getPath(root.left, n, path);
            boolean rightFound = getPath(root.right, n, path);

            if (leftFound || rightFound) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }

        public static Node lca(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            // finding least common ancestor
            int i = 0;
            for (; i < path1.size() && i < path2.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                } // our lca will be at i-1 not i cause loop was exited when equal condn has gone
            }
            Node lca = path1.get(i - 1);
            return lca;
        }

        public static Node lca2(Node root, int n1, int n2) {
            if (root == null) {
                return null;
            }

            if (root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftlca = lca2(root.left, n1, n2);
            Node rightlca = lca2(root.right, n1, n2);

            // leftlca = valid rightlca = null
            if (rightlca == null) {
                return leftlca;
            }
            if (leftlca == null) {
                return rightlca;
            }

            return root;
        }

        public static int lcaDist(Node root, int n) {
            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }
            int leftdist = lcaDist(root.left, n);
            int rightdist = lcaDist(root.right, n);

            if (leftdist == -1 && rightdist == -1) {
                return -1;
            } else if (leftdist == -1) {
                return rightdist + 1;
            } else {
                return leftdist + 1;
            }
        }

        public static int minDist(Node root, int n1, int n2) {
            Node lca = lca2(root, n1, n2);
            int dist1 = lcaDist(lca, n1);
            int dist2 = lcaDist(lca, n2);
            return dist1 + dist2;
        }

        public static int kAncestor(Node root, int n, int k) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftdist = kAncestor(root.left, n, k);
            int rightdist = kAncestor(root.right, n, k);

            if (leftdist == -1 && rightdist == -1) {
                return -1;
            }
            int max = Math.max(leftdist, rightdist);
            if (max + 1 == k) {
                System.out.println(root.data);
            }
            return max + 1;
        }

        public static int transform(Node root) {

            if (root == null) {
                return 0;
            }
            int leftChild = transform(root.left);
            int rightChild = transform(root.right);

            int data = root.data;

            int newleft = root.left == null ? 0 : root.left.data;
            int newright = root.right == null ? 0 : root.right.data;

            root.data = newleft + leftChild + newright + rightChild;
            return data;
        }

    }

    public static void main(String[] args) {
        // int Nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(Nodes);
        // System.out.println(root.data);

        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);
        // tree.levelOrder(root);
        // 1
        // / \
        // 2 3
        // / \ /\
        // 4 5 6 7
        // System.out.println(tree.height(root));
        // System.out.println(tree.count(root));
        // System.out.println(tree.countSum(root));
        // System.out.println(tree.diameter(root).diam);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);
        // System.out.println(tree.isSubtree(root, subRoot));

        // tree.topview(root);
        // tree.kLevel(root, 3, 1);

        // int n1 = 4;
        // int n2 = 6;
        // System.out.println(tree.lca(root, n1, n2).data);
        // System.out.println(tree.lca2(root, n1, n2).data);
        // System.out.println(tree.minDist(root, n1, n2));

        // int n = 5;
        // int k = 2;
        // tree.kAncestor(root, n, k);
        tree.transform(root);
        tree.preorder(root);
    }
}
