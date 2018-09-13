package usualPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：
 * 正则表达式的验证
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-13
 */
public class RegexpMy {

    /**
     * 验证正则和输入的数据是否匹配
     *
     * @param str    输入的字符串
     * @param regexp 输入的睁着表达式
     * @return
     */
    public boolean isMatch(String str, String regexp) {
        boolean b = false;
        if (str.matches(regexp)) {
            return b = true;
        }
        return b;
    }

    /**
     * 按照正则取字符串中的数据
     *
     * @param str    要拆分的字符串
     * @param regexp 匹配的正则表达式
     * @param index  获取第几个值
     * @return 获取到的值
     */
    public String regexpSplit(String str, String regexp, int index) {
        String result = "没有匹配的值";

        // 这里的regexp是按照（）进行分割的
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            result = matcher.group(index);
        }
        return result;
    }

}
