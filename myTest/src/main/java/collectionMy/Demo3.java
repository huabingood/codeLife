package collectionMy;


import java.util.*;

public class Demo3 {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("001","huabingood");
        map.put("002","huangyuwei");

        Set<String> set = map.keySet();
        for(String s:set){
            System.out.println(map.get(s));
        }

        List<String> list = new ArrayList<>();
        list.add("huabingood");
        list.add("曹操");
        list.add("刘备");
        list.set(2,"孙权");
        list.add(3,"huangyuwei");
        list.add(3,"love");

        list.stream().forEach(ele->System.out.println(ele));
    }
}
