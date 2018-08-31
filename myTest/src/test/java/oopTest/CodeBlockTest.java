package oopTest;

import oop.CodeBlock;
import org.junit.Test;

public class CodeBlockTest {
    @Test
    public void test(){
        CodeBlock codeBlock = new CodeBlock();
        System.out.println(codeBlock.toString());
    }
    @Test
    public void test1(){
        CodeBlock codeBlock = new CodeBlock("华彬",22);
        System.out.println(codeBlock.toString());
    }
}
