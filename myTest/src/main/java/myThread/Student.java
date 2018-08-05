package myThread;

/**
 * 对方法加锁，并且使用this关键字，保证了数据的一致性
 * 使用标志位，能保证单生产，单消费模型的唯一性
 */
public class Student {
    private String name;
    private int age;
    // 表示第一步没有置
    private boolean flag = false;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取数据，如果有数据，方法就等待，让获取的方法运行，如果没有数据，自己就运行，让获取的等
     * @param name
     * @param age
     */
    public synchronized void setAll(String name,int age){
        if(!this.flag){
            this.name=name;
            this.age=age;

            this.flag = true;
            this.notify();
        }else{
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费者进行消费，如果没有数据就休眠，有数据就启动消费
     */
    public synchronized void get(){
        if(this.flag){
            this.notify();
            System.out.println(this.name+":"+this.age);
            this.flag=false;  // 消费后将标记置为假
        }else{
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
