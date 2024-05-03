import java.util.*;

public class HashMap1 {

    public static void main(String[] args) {
        // create
        HashMap<String, Integer> hm = new HashMap<>();

        // insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key = " + k + " , value = " + hm.get(k));
        }

        System.out.println(hm.entrySet());
    }
}
