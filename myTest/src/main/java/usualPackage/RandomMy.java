package usualPackage;

public class RandomMy {
    public static void main(String[] args){
        // Math.random() 生成一个 [0,1) 的double类型的伪随机数。
        // 因此生成一个指定范围的随机数就变成了 Math.random()*(最大值-最小值)+最大值
        // 因为返回的是double类型的数据，所以就必须强制转换一下 (int)(Math.random()*(最大值-最小值)+最大值)
        int i  = (int)(Math.random()*9+1);
        System.out.println(i);
    }
}
