package oopTest;

import oop.Books;
import org.junit.Test;

/**
 * 测试Books类是否正常
 */
public class BooksTest {
    @Test
    public void createObject(){
        Books book = new Books();
        book.setName("快学Scala");
        book.setAuthor("xxxx");
        book.setPrice(60);
        System.out.println(book.toString());
    }

    @Test
    public void createObject2(){
        Books book = new Books("java","huabingood",23.45);
        System.out.println(book.toString());
        book.setAuthor("hyw");
        System.out.println(book.getAuthor());
        System.out.println(book.toString());
    }
}
