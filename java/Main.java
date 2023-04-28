import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(10);
        list.add(22);
        list.add(33);

        int set = (int)list.set(1, 100);
        System.out.println("set = " + set);
    }
}