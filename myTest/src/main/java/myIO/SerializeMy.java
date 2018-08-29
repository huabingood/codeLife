package myIO;

import java.io.*;

/**
 * 序列化的测试
 * 1.实例化一个实现Serializable接口的对象
 * 2.创建序列化IO流进行读写
 * 3.关闭序列化IO流
 */
public class SerializeMy {
    public static void main(String[] args){
        PersonBean pb = new PersonBean("huabingood",19);
        String path = "C:\\Users\\huabingood\\Desktop\\新建文件夹\\a.txt";

        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            // 写对象
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(pb);

            // 读对象
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
            PersonBean p = (PersonBean) objectInputStream.readObject();
            System.out.println(p);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null!=objectOutputStream){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=objectInputStream){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
