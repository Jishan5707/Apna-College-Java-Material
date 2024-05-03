import java.util.*;

public class PriorityQ2 {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(logn)
            // add at last index of arraylist
            arr.add(data);

            int x = arr.size() - 1; // x is child
            int par = (x - 1) / 2;// par index

            while (arr.get(x) < arr.get(par)) { // O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minidx = i;
            if (left < arr.size() && arr.get(minidx) > arr.get(left)) {
                minidx = left;
            }

            if (right < arr.size() && arr.get(minidx) > arr.get(right)) {
                minidx = right;
            }

            if (minidx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);

                heapify(minidx);
            }
        }

        public int remove() {
            int data = arr.get(0);
            // swap first and last

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2 delete last element
            arr.remove(arr.size() - 1);

            // heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }

    public static void heapify2(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxInd = i;

        if (left < size && arr[left] > arr[maxInd]) {
            maxInd = left;
        }

        if (right < size && arr[right] > arr[maxInd]) {
            maxInd = right;
        }

        if (maxInd != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxInd];
            arr[maxInd] = temp;

            heapify2(arr, maxInd, size);
        }
    }

    public static void heapsort(int arr[]) {
        // step-1 build maxheap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify2(arr, i, n);
        }

        // step-2 push larges at the end
        for (int i = n - 1; i > 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify2(arr, 0, i);
        }
    }

    public static void main(String[] args) {

        // Heap pq = new Heap();
        // pq.add(3);
        // pq.add(4);
        // pq.add(1);
        // pq.add(5);
        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek());
        // pq.remove();
        // }

        int arr[] = { 1, 2, 4, 5, 3 };
        heapsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
