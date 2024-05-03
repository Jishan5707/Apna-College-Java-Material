public class Divide_Con {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }

    public static void MergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // Kaam
        int mid = si + (ei - si) / 2; // (si+ei)/2
        MergeSort(arr, si, mid);
        MergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei); // this is the process of merging the two arrays
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;// iterator for left
        int j = mid + 1;// iterator for right
        int k = 0;// iterator for temp array

        while (i <= mid && j <= ei) { // isme compare karke copy kar diya temp me
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            }

            if (arr[i] >= arr[j]) {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        // isme bache hue elements ko copy karna hai
        // left par ke liye
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        // right part ke liye
        while (j <= ei) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        // Copy temp to main array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void QuickSort(int arr[], int si, int ei) {

        if (si >= ei) {
            return;
        }

        // We will do partition of array around pivot i.e. return the index of pivot
        // after comparing and placing them properly

        int pidx = partition(arr, si, ei);
        QuickSort(arr, si, pidx - 1);
        QuickSort(arr, pidx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for the elements less than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j]; // if element is smaller than the pivot then swap with i
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot; // at last swap the pivot with the i to get the proper position
        arr[ei] = arr[i];
        arr[i] = temp; // pivot is nothing but arr[ei]

        // and now we will return the index of pivot i.e i as we have stored pivot at i
        return i;
    }

    public static int searchR(int arr[], int tar, int si, int ei) {
        // base case
        if (si > ei) {
            return -1;
        }

        // kaam
        int mid = si + (ei - si) / 2;

        // ele found
        if (arr[mid] == tar) {
            return mid;
        }

        // mid lie on line 1
        if (arr[si] <= arr[mid]) {

            // caes a
            if (arr[si] <= tar && tar <= arr[mid]) {
                return searchR(arr, tar, si, mid - 1);
            }
            // case b
            else {
                return searchR(arr, tar, mid + 1, ei);
            }
        } else { // mid on line 2

            // case c
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return searchR(arr, tar, mid + 1, ei);
            }
            // case d
            else {
                return searchR(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 6, 3, 9, 5, 2, 8 }; // array is made
        // MergeSort(arr, 0, arr.length - 1);
        // printArr(arr);

        // QuickSort(arr, 0, arr.length - 1);
        // printArr(arr);

        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6; // output -> 4
        System.out.println(searchR(arr, target, 0, arr.length - 1));

    }
}
