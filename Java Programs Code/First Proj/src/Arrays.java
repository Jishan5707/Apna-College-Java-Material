import java.util.*;

public class Arrays {

    public static void Update(int num[]) {
        for (int i = 0; i < num.length; i++) {
            num[i] = num[i] + 1;
        }
    }

    public static void PrintArr(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Linear search function
    public static int LinearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int getLargest(int numbers[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }
        return largest;
    }

    public static int BinarySearch(int numbers[], int key) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // Comparisons
            if (numbers[mid] == key) {
                return mid;
            }
            if (key < numbers[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void ReverseArray(int numbers[]) {
        int first = 0;
        int last = numbers.length - 1;
        while (first < last) {
            int temp = numbers[first];
            numbers[first] = numbers[last];
            numbers[last] = temp;

            first++;
            last--;
        }
    }

    // Creating pairs of elements in the array
    public static void printPairs(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];// First element selection

            for (int j = i + 1; j < numbers.length; j++) { // Second element selection
                System.out.print("(" + current + "," + numbers[j] + ")");
            }
            System.out.println();
        }
    }

    // Creating a function to print all the subarrays of a given array
    public static void PrintSubarray(int numbers[]) {
        int total = 0;
        // Selecting first part of array
        for (int i = 0; i < numbers.length; i++) {
            // selecting the second part
            for (int j = i; j < numbers.length; j++) {
                // Printing the subarrays
                for (int k = i; k <= j; k++) {
                    System.out.print(numbers[k] + " ");
                }
                total++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total sub arrays are : " + total);
    }

    // Function for finding Max Subarray sum
    public static void MaxSubArrSum(int numbers[]) {

        int Max_Sum = Integer.MIN_VALUE;

        // Selecting first part of array
        for (int i = 0; i < numbers.length; i++) {
            // selecting the second part
            for (int j = i; j < numbers.length; j++) {
                // Finding the sum of each subarray
                int current_Sum = 0;
                for (int k = i; k <= j; k++) {
                    current_Sum = current_Sum + numbers[k];
                }
                if (current_Sum > Max_Sum) {
                    Max_Sum = current_Sum;
                }
            }
        }
        System.out.println("Maximum sum is : " + Max_Sum);
    }

    public static void MaxSubArrSum2(int numbers[]) {

        int Max_Sum = Integer.MIN_VALUE;
        int current_Sum = 0;

        // Selecting first part of array
        int prefix[] = new int[numbers.length];
        int start;
        int end;

        // Calculating prefix array
        prefix[0] = numbers[0];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        // selecting first part
        for (int i = 0; i < prefix.length; i++) {
            start = i;
            // Selecting second part
            for (int j = i; j < prefix.length; j++) {
                end = j;

                // Now calculating the current sum
                if (start == 0) {
                    current_Sum = prefix[end];
                } else {
                    current_Sum = prefix[end] - prefix[start - 1];
                }

                // Comparing Current with maxsum
                if (current_Sum > Max_Sum) {
                    Max_Sum = current_Sum;
                }
            }
        }
        System.out.println("Maximum sum is : " + Max_Sum);
    }

    // KADANES Algorithm
    public static void Kadanes(int numbers[]) {
        int current_Sum = 0;
        int Max_Sum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            current_Sum = current_Sum + numbers[i];
            if (current_Sum < 0) {
                current_Sum = 0;
            }
            if (current_Sum > Max_Sum) {
                Max_Sum = current_Sum;
            }
        }
        System.out.println("Maximum sum is : " + Max_Sum);
    }

    // trapping rain water problem
    public static int TrappedRainWater(int height[]) {
        int n = height.length;
        // Calculate left max boundry - Array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Calculate right max boundry - Array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        // loop
        for (int i = 0; i < n; i++) {
            // waterlevel = min(leftMax boundry,rightmax boundry)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);

            // trapped water = waterlevel-height of bar height[i]
            trappedWater = trappedWater + (waterlevel - height[i]);
        }
        return trappedWater;
    }

    // Dummy function same as above
    public static int TrappedRainWater2(int height[]) {
        int n = height.length;

        int leftmax[] = new int[n];
        leftmax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }

        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            trappedWater += waterlevel - height[i];
        }
        return trappedWater;
    }

    // Getting maximum profit from the stocks
    public static int BuySellStocks(int price[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < price.length; i++) {
            if (buyprice < price[i]) {
                int profit = price[i] - buyprice;
                maxprofit = Math.max(maxprofit, profit);
            } else {
                buyprice = price[i];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Arrays are call by reference dataTypes

        // int marks[] = new int[50];

        int num[] = { 1, 2, 3 };
        Update(num);
        PrintArr(num);

        // for (int i = 0; i < num.length; i++) {
        // System.out.print(num[i] + " ");
        // }
        // System.out.println();
        // PrintArr(num);

        // int key = 10;

        // int index = LinearSearch(numbers, key);

        // if (index == -1) {
        // System.out.println("NOT Found");
        // } else {
        // System.out.println("The index of the key is " + index);
        // }

        // PrintArr(numbers);
        // System.out.println("Largest number is " + getLargest(numbers));

        // int numbers[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int numbers[] = { 2, 4, 6, 8, 10 };

        // System.out.println("The index of key is " + BinarySearch(numbers, 12));

        // ReverseArray(numbers);
        // PrintArr(numbers);

        int numb[] = { 1, -2, 6, -1, 3 };

        // printPairs(numbers);

        // PrintSubarray(numbers);

        int ArrayDemo[] = new int[50];
        int ArrayDemo2[] = { 1, 2, 3, 4, 5, 6 };
        String ArrayDemo3[] = { "Ajat", "Mango", "Space " };

        int height[] = { 4, 2, 0, 6, 3, 2, 5 };

        MaxSubArrSum(numb);

        MaxSubArrSum2(numb);

        Kadanes(numb);

        System.out.println("The total water trapped is : " + TrappedRainWater(height));
        System.out.println("The total water trapped is : " + TrappedRainWater2(height));

        int price[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("The maximum profit is : " + BuySellStocks(price));

    }

}
