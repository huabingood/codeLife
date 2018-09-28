package collectionMy;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();

        list.add("huabingood");
        list.add("huangyuwei");
        list.add("love");

        System.out.println(list.isEmpty());
        System.out.println(list.size());

    }
}
