import java.util.*;

public class temp {

    public static void datatype(String type) {
        String s1 = "integer";
        if (type.equals(s1)) {
            System.out.println(2);
        } else {
            System.out.println(-1);
        }
        return;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String type;
        type = input.next();
        datatype(type);
        int a = 5;
        System.out.println(a);
    }
}
