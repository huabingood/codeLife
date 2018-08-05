package myThreadTest;

import myThread.Student;
import myThread.StudentCustomer;
import myThread.StudentProducer;

/**
 * 主调函数，保证中间通信方式的唯一性即可，就student对象必须在main方法中实例化
 */
public class SutdentTest {

    public static void main(String[] args){
        // student对象必须在外部生命，否者对象就不是同一对象了，也就无法保证加锁的排他性
        Student s = new Student();

        StudentProducer  studentProducer = new StudentProducer(s);
        StudentCustomer studentCustomer = new StudentCustomer(s);

        Thread t1 = new Thread(studentCustomer,"消费者");
        Thread t2 = new Thread(studentProducer,"生产者");

        t1.start();
        t2.start();

        arrayb
    }
}
