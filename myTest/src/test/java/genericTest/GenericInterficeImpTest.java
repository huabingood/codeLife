package genericTest;

import generic.GenericInterficeImp;
import org.junit.Test;

public class GenericInterficeImpTest {
    @Test
    public void testShow() {
        GenericInterficeImp<String,Integer> gii = new GenericInterficeImp("huabingood",29);
        gii.show();
    }
}
