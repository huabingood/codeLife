package myThread;

/**
 * 生产者进行生产
 * 因为student的方法都加锁了，因此不用担心给对象赋值会被弄乱
 */
public class StudentProducer implements Runnable {
    Student student;
    int i=0;

    public StudentProducer(Student student) {
        this.student = student;
    }
    public StudentProducer() {
    }

    @Override
    public void run() {
        while(true){
            if(i%3==0){
                student.setAll("huabingood",18);
            }else{
                student.setAll("hyw",17);
            }
            i++;
        }

    }
}
