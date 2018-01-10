package chap01;

/**
 * Created by Joe on 2017/9/6.
 */
public class Gate {
    private int count;
    private String name = "Nobody";
    private String address = "Nowhere";

    public void pass(String name, String address) {
        this.count++;
        this.name = name;
        this.address = address;

        check();
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***Broken***" + toString());
        }

    }

    @Override
    public String toString() {
        return "No." + count + ":" + name + "," + address;
    }
}
