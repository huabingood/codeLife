package myThread;

/**
 * 负责消费的代码
 */
public class StudentCustomer implements Runnable {
    Student student;

    public StudentCustomer(Student student) {
        this.student = student;
    }

    public StudentCustomer() {
    }

    @Override
    public void run() {
        while(true){
            student.get();
        }
    }
}
