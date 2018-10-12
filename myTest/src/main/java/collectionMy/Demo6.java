package collectionMy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo6 {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(30);
        l.add(25);
        l.add(100);
        l.add(45);
        l.add(10);

        int i = Collections.binarySearch(l, 25);

        System.out.println(i);
        l.stream()
                .forEach(x -> System.out.println(x));

    }
}
