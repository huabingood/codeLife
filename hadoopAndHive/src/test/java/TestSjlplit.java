import java.util.Arrays;

public class TestSjlplit {
    public static void main(String[] args){
        String line = "1363157993055 \t13560436666\tC4-17-FE-BA-DE-D9:CMCC\t120.196.100.99\t\t\t18\t15\t1116\t954\t200";
        String[] words = line.split("\t");

        Arrays.stream(words).forEach(word->System.out.println(word));


        System.out.println("--------------------------");
        System.out.println(words[words.length-1]);

        // System.out.println(words[0]);
    }

}
