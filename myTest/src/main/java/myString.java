public class myString {
    public static void main(String[] args){
        // 字符串相加，或者直接使用+；在StringBuffer中使用append()
        String str1 = "huabingood";
        String str2 = "hyw";
        System.out.println(str1.concat(str2));

        
        System.out.println("-------------------------------------");
        /**
         * 截取子字符串
         * 字符串的下标是从0开始的，因为0是数组的开始
         * substring(int 开始下标)
         * substring(int 开始下标，int 结束位置)    // 这个跟通常的不一样，通常最后一个标识长度
         * 
         */
        StringBuffer sb = new StringBuffer("huabingoodlovehyw");
        System.out.println(sb.substring(3));
        System.out.println(sb.substring(2,10));

        System.out.println("-------------------------------------");
        /**
         * 获取单个字符
         * charAt(int index)
         * 通过下标获取该字符串中的某个下标的字符
         */
        System.out.println(str1.charAt(0));

        System.out.println("-------------------------------------");
        /**
         * 获取长度
         * length() 获取的是实际长度
         * capacity() 获取的是字符缓冲区的容量，不但是字符个数还有缓冲区的大小
         */
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        System.out.println("-------------------------------------");
        /**
         * 字符串相等
         * == 比较的是地址值
         * equals() 实际上是交个使用者定义的比较，使用者如何定义，就如何比较。
         * 在string中，实际上是重写了equals的方法，不仅比较地址值，还比较值
         */
        if(str1.equals(str2)){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }

        System.out.println("-------------------------------------");
        /**
         * 查找子串
         * indexOf(子串内容)  返回第一次出现子串的位置
         * contain()  是否包含，返回的是布尔值
         * startsWith(子串内容) 是否已以子串开头
         * endsWith(子串内容)  是否以子串结尾
         *
         * */
        System.out.println("-------------------------------------修改");
        System.out.println(str1.replace("hua","eff"));

    }
}
