package simpleDemo;

public class ByteLength {
    public static void main(String[] args){
        String s = "中国";
        byte[] bytes = s.getBytes();
        int len =0;

        for(byte b :bytes){
            if((b & 0xC0) != 0x80){
                len++;
            }
        }
        System.out.println(len);
    }
}


