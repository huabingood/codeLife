package practise;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test2 {
    public static void main(String[] args){
        double d = 12.32622;
        String s = "12.3";
        BigDecimal n = new BigDecimal(d)
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println(n);
    }
}
