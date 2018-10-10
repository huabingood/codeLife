package practise;

import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("huaingood");
        list.add("huangyuwei");
        list.add("hahha");

        System.out.println(list.toString());


        Set<String> set = new HashSet<>();
        set.add("huabingood");
        set.add("huangyuwei");
        set.add("huabingood");

        for (String s : set) {
            System.out.println(s);
        }

        // 如果只是使用一次的话，使用匿名内部类的方式，在TreeSet的构造器中传入一个比较器类即可
        TreeSet<Student2> ts = new TreeSet<>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                int num = o1.getAge() - o2.getAge();

                num = num == 0 ? o1.getName().compareTo(o2.getName()) : num;

                return num;
            }
        });

        float f  = 123456789.1234f;
        System.out.println(f);


    }
}
