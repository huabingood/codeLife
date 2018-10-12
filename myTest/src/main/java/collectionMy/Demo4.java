package collectionMy;

import java.util.ArrayList;
import java.util.List;

/**
 * 不借助中间集合，去除list中的重复值
 */
public class Demo4 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("huabingood");
        list.add("huangyuwei");
        list.add("huabingood");
        list.add("love");

        // 通过不断的子循环来实现
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }

        list.stream().forEach(e -> System.out.println(e));
    }
}
