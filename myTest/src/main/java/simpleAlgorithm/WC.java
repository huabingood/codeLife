package simpleAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 统计一个字符串中各个数字出现的次数
 */
public class WC {


    public static void main(String[] args){
        String str = "abcdaabbcc";

        Map<Character,Integer> wc = new HashMap<>(10);
        Set<Character> keys = wc.keySet();

        for(int i=0;i<str.length()-1;i++){
            char now = str.charAt(i);
            if (keys.contains(now)){
                wc.put(now,wc.get(now)+1);
            }else{
                wc.put(now,1);
            }

        }

        System.out.println(wc.toString());
    }
}
