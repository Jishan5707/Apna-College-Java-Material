public class Recursion {
    public static void PrintDec(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        PrintDec(n - 1);
    }

    public static void PrintInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        PrintInc(n - 1);
        System.out.print(n + " ");
    }

    public static int Fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * Fact(n - 1);
        }
    }

    public static int SumToN(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + SumToN(n - 1);
        }
    }

    public static int Fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int FibN = Fibo(n - 1) + Fibo(n - 2);

        return FibN;
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int FirstOccur(int arr[], int key, int i) {
        if (i == arr.length - 1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        } else {
            return FirstOccur(arr, key, i + 1);
        }
    }

    public static int LastOccur(int arr[], int key, int i) {
        // i is last index
        if (i == 0) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return LastOccur(arr, key, i - 1);
    }

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    public static int Opower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if ((n % 2) == 0 && n != 0) {
            return Opower(x, n / 2) * Opower(x, n / 2);
        } else {
            return x * Opower(x, (n - 1) / 2) * Opower(x, (n - 1) / 2);
        }
    }

    public static int OPower(int x, int n) { // This function doesnt work properly
        if (n == 0) {
            return 1;
        }
        int HalfPower = OPower(x, n / 2);
        int HalfPowerSq = HalfPower * HalfPower;

        if (n % 2 != 0) {
            HalfPowerSq = x * HalfPower;
        }
        return HalfPowerSq;
    }

    public static int opower(int x, int n) { // similar optimized function works
        if (n == 0) {
            return 1;
        }
        if ((n % 2) == 0 && n != 0) {
            int HalfPower = opower(x, n / 2);
            return HalfPower * HalfPower;
        } else {
            int HalfPower2 = opower(x, (n - 1) / 2);
            return x * HalfPower2 * HalfPower2;
        }
    }

    public static int TilingProb(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int Vertical = TilingProb(n - 1);

        int Horizontal = TilingProb(n - 2);

        int Total = Vertical + Horizontal;

        return Total;
    }

    public static void RemoveDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            RemoveDuplicate(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            RemoveDuplicate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static int FriendPair(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return FriendPair(n - 1) + (n - 1) * FriendPair(n - 2);
    }

    public static void BString(int n, int lastplace, String Str) {
        if (n == 0) {
            System.out.println(Str);
            return;
        }
        if (lastplace == 0) {
            BString(n - 1, 0, Str + "0");
            BString(n - 1, 1, Str + "1");
        } else {
            BString(n - 1, 0, Str + "0");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        // PrintInc(n);
        // System.out.println(Fact(5));
        // System.out.println(SumToN(5));
        // System.out.println(Fibo(7));

        // int arr[] = { 1, 2, 3, 5, 4, 5, 5, 5, 5 };
        // System.out.println(isSorted(arr, 0));

        // System.out.println(FirstOccur(arr, 5, 0));

        // System.out.println(LastOccur(arr, 5, arr.length - 1));

        // System.out.println(pow(2, 10));
        // System.out.println(Opower(2, 10));
        // System.out.println(OPower(2, 11));
        // System.out.println(opower(2, 11));

        // System.out.println(TilingProb(4));

        String str = "jjiisshhaann";
        boolean map[] = new boolean[26];
        RemoveDuplicate(str, 0, new StringBuilder(""), map);

        System.out.println(FriendPair(3));

        BString(3, 0, "");
    }

}
