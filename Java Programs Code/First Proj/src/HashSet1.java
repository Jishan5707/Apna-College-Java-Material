import java.util.*;

public class HashSet1 {

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static String freqSort(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getKey());
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.add(e);
        }
        StringBuilder res = new StringBuilder();

        while (pq.size() != 0) {
            char ch = pq.poll().getKey();
            int val = map.get(ch);
            while (val != 0) {
                res.append(ch);
                val--;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // HashSet<Integer> hs = new HashSet<>();
        // // hs.add(1);
        // // hs.add(2);
        // // hs.add(3);
        // // hs.add(2);
        // // hs.add(1);
        // // System.out.println(hs);
        // // System.out.println(hs.contains(2));
        // // System.out.println(hs.remove(2));
        // // System.out.println(hs.contains(2));

        // HashSet<String> cities = new HashSet<>();
        // cities.add("Pune");
        // cities.add("Mumbai");
        // cities.add("Delhi");
        // cities.add("Nagpur");

        // Iterator it = cities.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }
        // System.out.println();

        // // for (String city : cities) {
        // // System.out.println(city);
        // // }

        // LinkedHashSet<String> lhs = new LinkedHashSet<>();

        // lhs.add("Pune");
        // lhs.add("Mumbai");
        // lhs.add("Delhi");
        // lhs.add("Nagpur");

        // Iterator it2 = lhs.iterator();
        // while (it2.hasNext()) {
        // System.out.println(it2.next());
        // }
        // System.out.println();

        // TreeSet<String> ts = new TreeSet<>();

        // ts.add("Pune");
        // ts.add("Mumbai");
        // ts.add("Delhi");
        // ts.add("Nagpur");

        // Iterator it3 = ts.iterator();
        // while (it3.hasNext()) {
        // System.out.println(it3.next());
        // }
        // System.out.println();

        // HashSet<Integer> hs = new HashSet<>();
        // int nums[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        // for (int i = 0; i < nums.length; i++) {
        // hs.add(nums[i]);
        // }
        // System.out.println(hs.size());

        // int arr1[] = { 7, 3, 9 };
        // int arr2[] = { 6, 3, 9, 2, 9, 4 };

        // HashSet<Integer> set = new HashSet<>();

        // for (int i = 0; i < arr1.length; i++) {
        // set.add(arr1[i]);
        // }
        // for (int i = 0; i < arr2.length; i++) {
        // set.add(arr2[i]);
        // }

        // Iterator it = set.iterator();
        // while (it.hasNext()) {
        // System.out.print(it.next() + " ");
        // }
        // System.out.println();

        // System.out.println("Union size = " + set.size());

        // set.clear();

        // for (int i = 0; i < arr1.length; i++) {
        // set.add(arr1[i]);
        // }

        // int count = 0;
        // for (int i = 0; i < arr2.length; i++) {
        // if (set.contains(arr2[i])) {
        // count++;
        // System.out.print(arr2[i] + " ");
        // set.remove(arr2[i]);
        // }
        // }
        // System.out.println();

        // System.out.println("Intersection size = " + count);

        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");

        // String start = getStart(tickets);

        // for (String key : tickets.keySet()) {
        // System.out.println(start + " -> " + tickets.get(start));
        // start = tickets.get(start);
        // }

        // //subarray sum = 0 question
        // int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        // HashMap<Integer, Integer> map = new HashMap<>();
        // // (sum,index)

        // int sum = 0;
        // int length = 0;
        // for (int j = 0; j < arr.length; j++) {
        // sum += arr[j];
        // if (map.containsKey(sum)) {
        // length = Math.max(length, j - map.get(sum));
        // } else {
        // map.put(sum, j);
        // }
        // }

        // System.out.println("largest sub array has length = " + length);

        // // subarray sum = k question
        // int arr[] = { 10, 2, -2, -20, 10 };
        // int k = -10;

        // HashMap<Integer, Integer> map = new HashMap<>();
        // // (sum,count)
        // map.put(0, 1);

        // int sum = 0;
        // int ans = 0;
        // for (int j = 0; j < arr.length; j++) {
        // sum += arr[j];
        // if (map.containsKey(sum - k)) {
        // ans += map.get(sum - k);
        // }
        // map.put(sum, map.getOrDefault(sum, 0) + 1);
        // }

        // System.out.println(ans);

        String s = "abbccceeeffff   ";

        System.out.println(freqSort(s));
    }
}