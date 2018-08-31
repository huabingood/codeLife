package oop;

/**
 * 华氏度和设置度的相互转换
 * @author huabingood
 * @date
 * @version 1.0
 */
public class FCDegree {

    public static final int MegicNum=32;
    public static final float CHUSHU = 1.8F;

    public FCDegree() {
    }

    /**
     *
     * @param f
     * @return
     */
    public double f2c(double f){
        double newC=0;
        newC= (f-MegicNum)/CHUSHU;
        return newC;
    }

    public double c2f(double c){
        double newF=0;
        newF = (c*CHUSHU)+MegicNum;
        return newF;
    }
}
