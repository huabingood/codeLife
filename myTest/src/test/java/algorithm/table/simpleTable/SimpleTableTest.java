package algorithm.table.simpleTable;

import org.junit.Before;
import org.junit.Test;

public class SimpleTableTest {
    SimpleTable st;
    @Before
    public void initial(){
        st = new SimpleTable(20);
    }

    @Test
    public void testAutoIncrementXapacity(){
        st.autoIncrementXapacity();
    }

    @Test
    public void testPrintList(){
        st.printList();
    }

}
