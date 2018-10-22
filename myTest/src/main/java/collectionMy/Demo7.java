package collectionMy;

import java.util.HashSet;
import java.util.Set;

public class Demo7 {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(10);
        set.add(6);
        set.add(33);

        set.stream().forEach(x->System.out.println(x));
        boolean b = set.remove(44);
        boolean c = set.remove(33);
        System.out.println(b);
        System.out.println(c);
        set.stream().forEach(x->System.out.println(x));

    }

}
