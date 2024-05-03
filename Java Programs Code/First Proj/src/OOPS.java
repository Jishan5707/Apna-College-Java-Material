public class OOPS {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setcolor("blue");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setcolor("blue");
        System.out.println(p1.getColor());

        BankAccount b1 = new BankAccount();
        b1.username = "JIshanP";
        b1.setPassword("ABCD");
        System.out.println(b1.username);
    }
}

class BankAccount {
    public String username;
    private String password; // Private thing cannot be accesed outside the class in which it is defined

    public void setPassword(String pwd) {
        password = pwd;
    }
}

class Pen {
    private String color;
    private int tip;

    String getColor() { // By making the get function we can access the private information
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setcolor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}
