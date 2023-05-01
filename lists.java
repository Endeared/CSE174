import java.util.ArrayList;

public class lists {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("this is a string");
        list.add("this is another string");

        System.out.println(list.get(1));
    }
}
