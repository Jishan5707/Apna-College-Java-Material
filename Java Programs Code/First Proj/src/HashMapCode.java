import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.value = value;
                this.key = key;
            }
        }

        private int n;
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("uncheked")
        public HashMap() {
            this.n = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % n;
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        public void put(K key, V value) {
            int bi = hashFunction(key); // 0 to 3
            int di = SearchInLL(key); // valid or -1

            if (di != 1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            int lambda
        }
    }
}
