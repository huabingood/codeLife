package practise;

public class Student2 implements Comparable<Student2> {

    private String name;
    private int age;

    public Student2() {
    }

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 按照年龄对对象进行排序
     * 如果年龄相同，按照姓名的首字母进行排序
     *
     * @param o
     * @return 如果返回0表示相同，如果返回负数表示进来的值大，如果返回的整数表示进来的值小。
     */
    @Override
    public int compareTo(Student2 o) {
        int num = 0;
        // 比较年龄
        num = this.age - o.age;
        // 如果年龄相同就比较姓名
        num = num == 0 ? this.name.compareTo(o.name) : num;

        return num;
    }
}
