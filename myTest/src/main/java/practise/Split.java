package practise;

// 分类处理

/**
 * Z853/857    综合性图书图书目录、文摘、索引出版发行目录各国
 * Z863/867    综合性图书图书目录、文摘、索引个人著作目录各国
 * TB913/917   工业技术一般工业技术计量学计量单位与单位制各国单位制
 *
 * ([a-zA-Z]{1,2})(\d+)(/)(\d+)
  */

/**
 * F239.23/.27 经济经济计划与管理审计审计工作组织与制度各国
 * J222.2/.6   艺术绘画中国绘画作品中国画历代作品
 *
 * ([a-zA-Z]{1,2})(\d+)(\.)(\d+)(/)(\.)(\d+)
 */

/**
 * T-013/-017  工业技术工业技术理论方针、政策及其阐述各国
 * T-653/-657  工业技术参考工具书工业规程与标准各国
 * TU-093/-097 工业技术建筑科学建筑理论建筑史各国建筑史
 *
 * ([a-zA-Z]{1,2})(-)(\d+)(/)(-)(\d+)
 */

/**
 * J432/439.9  艺术摄影艺术世界各国摄影艺术各种摄影艺术作品
 *
 * ([a-zA-Z]{1,2})(\d+)(/)(\d+)(\.)(\d+)
 */

/**
 * TU-092.1/.7 工业技术建筑科学建筑理论建筑史中国建筑史各时代建筑史
 *
 * ([a-zA-Z]{1,2})(\-)(\d+)(\.)(\d+)(/)(\.)(\d+)
 */

/**
 * P1-093/-097   天文学、地球科学天文学理论与方法论天文学史各国
 *
 * ([a-zA-Z]{1,2})(\d+)(-)(0)(\d+)(/)(-)(0)(\d+)
 */

/**
 * S851.34+5.3/.7    农业科学畜牧、动物医学、狩猎、蚕、蜂动物医学（兽医学）家畜卫生及防疫家畜流行病学、防疫动物检疫（兽医检疫）国境检疫各国检疫
 *
 * ([a-zA-Z]{1,2})(\d+)(\.)(\d+)(\+)(\d+)(\.)(\d+)(\/)(\.)(\d+)
 */



import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Split {
    static Pattern r=null;
    static Matcher m =null;


    public static void main(String[] args){
        //String chinatypes=args[0];

        String chinatypes="E292/294.9\t军事中国军事军事史（战史、建军史）古代军事史古代各时期军事史（1840年以前）";


        String[] regexps={
                "([a-zA-Z]{1,2})(\\d+)(/)(\\d+)",
                "([a-zA-Z]{1,2})(\\d+)(\\.)(\\d+)(/)(\\.)(\\d+)",
                "([a-zA-Z]{1,2})(\\-)(\\d+)(/)(-)(\\d+)",
                "([a-zA-Z]{1,2})(\\d+)(/)(\\d+)(\\.)(\\d+)",
                "([a-zA-Z]{1,2})(\\-)(\\d+)(\\.)(\\d+)(/)(\\.)(\\d+)",
                "([a-zA-Z]{1,2})(\\d+)(-)(0)(\\d+)(/)(-)(0)(\\d+)",
                "([a-zA-Z]{1,2})(\\d+)(\\.)(\\d+)(\\+)(\\d+)(\\.)(\\d+)(\\/)(\\.)(\\d+)"};

        // 因为每个分割的组都不一致，需要单独做处理
        for(int i=0;i<regexps.length;i++){
            r = Pattern.compile(regexps[i]);
            m = r.matcher(chinatypes.split("\t")[0]);
            if(m.matches()){
                splitRegexp(i,chinatypes);
            }
        }


    }

    public static void splitRegexp(int i,String chinatype){
        Integer start ;
        Integer end;
        String fatherChinatype= chinatype.split("\t")[1];

        switch (i){
            case 0:
                start = Integer.valueOf(m.group(2));
                end = Integer.valueOf(m.group(4));
                getSQLCmd(start,end,1,fatherChinatype);
                break;
            case 1:
                start = Integer.valueOf(m.group(4));
                end = Integer.valueOf(m.group(7));
                getSQLCmd(start,end,3,fatherChinatype);
                break;
            case 2:
                start = Integer.valueOf(m.group(3));
                end = Integer.valueOf(m.group(6));
                String flag = m.group(3);
                if(flag.startsWith("0")){
                    getSQLCmd(start,end,"0",fatherChinatype);
                }else{
                    getSQLCmd(start,end,2,fatherChinatype);
                }
                break;
            case 3:
                start = Integer.valueOf(m.group(2));
                end = Integer.valueOf(m.group(4));
                getSQLCmd(start, end,1,fatherChinatype);
                break;
            case 4:
                start = Integer.valueOf(m.group(5));
                end = Integer.valueOf(m.group(8));
                getSQLCmd(start,end,4,fatherChinatype);
                break;
            case 5:
                start = Integer.valueOf(m.group(5));
                end = Integer.valueOf(m.group(9));
                getSQLCmd(start, end,4,fatherChinatype);
                break;
            case 6:
                start = Integer.valueOf(m.group(8));
                end = Integer.valueOf(m.group(11));
                getSQLCmd(start,end,7,fatherChinatype);

        }
    }

    /**
     * 负责拼接SQL
     * 
     * @param start 起始值
     * @param end 结束值
     * @param len 被正则分组的不变的长度，TU-092.1/.7 被我们分成8份，不变的长度是4，因为TU-092.是不变的
     * @param fatherChinatype
     */
    public static void getSQLCmd(int start,int end,int len,String fatherChinatype){
        for(;start<=end;start++){
            String chinatype=null;
            for(int i=1;i<=len;i++){
                if(null==chinatype){
                    chinatype=m.group(i);
                }else {
                    chinatype = chinatype + m.group(i);
                }
            }
            chinatype=chinatype+start;
            System.out.println("insert into luka_biz.t_zt_type(code,type_name) values('"+chinatype+"','"+fatherChinatype+"');");
        }
    }

    /**
     * 对于T-013/-017带0的格式，要特别的处理循环中的0，我们把0放入add参数中
     * @param start
     * @param end
     * @param add 不安顺序出现的拼接字符
     * @param fatherChinatype
     */
    public static void getSQLCmd(int start,int end,String add,String fatherChinatype){
        for(;start<=end;start++){
            String chinatype=m.group(1)+m.group(2)+add+start;
            System.out.println("insert into luka_biz.t_zt_type(code,type_name) values('"+chinatype+"','"+fatherChinatype+"');");
        }
    }
}
