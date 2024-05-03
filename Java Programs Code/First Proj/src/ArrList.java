import java.util.*;

public class ArrList {

    public static int storeWaterMax(ArrayList<Integer> height) {
        int maxWater = 0;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = ht * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }

        return maxWater;
    }

    // two pointer approach to ssolve the question
    public static int storeWaterMax2(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp) {

            // calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            // update pointers
            if (height.get(lp) > height.get(rp)) {
                rp--;
            } else {
                lp++;
            }
        }

        return maxWater;
    }

    public static boolean pairSum(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (target == list.get(i) + list.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum_Opt(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp + 1;
        int rp = bp;

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList();

        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);
        // // System.out.println(list);

        // // System.out.println(list.get(0));
        // // list.remove(0);
        // // System.out.println(list);

        // // list.set(0, 5);
        // // System.out.println(list);

        // // System.out.println(list.contains(5));

        // // list.add(0, 1);
        // // System.out.println(list);

        // System.out.println(list);

        // Collections.sort(list);
        // System.out.println(list);

        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // for (int i = 1; i <= 5; i++) {
        // list1.add(i * 1);
        // list2.add(i * 2);
        // list3.add(i * 3);
        // }

        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);

        // // System.out.println(mainList);

        // for (int i = 0; i < mainList.size(); i++) {
        // ArrayList<Integer> currlist = mainList.get(i);
        // for (int j = 0; j < currlist.size(); j++) {
        // System.out.print(currlist.get(j) + " ");
        // }
        // System.out.println();
        // }

        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // System.out.println(storeWaterMax2(height));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        // System.out.println(pairSum_Opt(list, target));
        System.out.println(pairSum2(list, target));

    }
}
