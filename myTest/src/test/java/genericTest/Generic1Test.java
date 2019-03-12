package genericTest;

import generic.Generic1;
import org.junit.Test;

public class Generic1Test {
    @Test
    public void testShow(){
        Generic1<String> g = new Generic1<String>("huabingood");
        g.show();
    }

    @Test
    public void testShow2(){
        Generic1<Integer> g2 = new Generic1<>(123);
        g2.show();
    }

}
