package usualPackage;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * 描述：
 * JDK8中日期新特性的实现
 * 这一层关于类的抽象做的还行，将公共参数放在代码块中有对象实例化时初始化
 *
 * @author huabingood@qq.com
 * @version 1.0
 * @create 2018-09-11
 */
public class DateMy {

    private LocalDate localDate;
    private LocalTime localTime;
    private ZonedDateTime zonedDateTime;
    private LocalDateTime localDateTime;
    private Instant instant;

    {
        localDate = LocalDate.now();
        localTime = LocalTime.now();
        zonedDateTime = ZonedDateTime.now();
        localDateTime = LocalDateTime.now();
        instant = Instant.now();
    }

    public DateMy() {
    }

    /**
     * LocalDate 专门获取日期，不包含时间
     * LocalTime 专门获取时间，不包含日期
     */
    public void getNowtime() {
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(zonedDateTime);
        System.out.println(localDateTime);
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());
    }

    /**
     * 根据小时间创建大时间
     */
    public void getObject() {
        LocalDate localDateObj = LocalDate.of(2018, 5, 14);
        ZonedDateTime zonedDateTimeObj = ZonedDateTime.of(localDate, localTime, ZoneId.of("+10:00"));

        String str = zonedDateTimeObj.toLocalDateTime().toString();

        ZonedDateTime z1 = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println(zonedDateTimeObj);
        System.out.println(str);
        System.out.println(z1.toLocalDateTime());
        System.out.println(LocalDateTime.ofInstant(z1.toInstant(), ZoneId.systemDefault()));

    }

    /**
     * 从日期中获取时分秒
     * 常用方法,注意LocalDate只能获取年月日，LocalTime只能获取时分秒毫秒纳秒
     * int getHour()
     * int getMinute()
     * int getSecond()
     * int getYear()
     * int getMonthValue()
     * Month getMonth()
     * int getDayOfMonth()
     */
    public void getSingleTime() {
        String localtime = "小时是：" + localTime.getHour()
                + "分钟是：" + localTime.getMinute()
                + "秒是：" + localTime.getSecond();

        String localdate = "年是：" + localDate.getYear()
                + "月是：" + localDate.getMonthValue()
                + "日是：" + localDate.getDayOfMonth();

        String month0 = localDate.getMonth().toString();
        int month1 = localDate.getMonthValue();

        String alltime = String.valueOf(zonedDateTime.getYear()) + zonedDateTime.getMonth() + zonedDateTime.getDayOfMonth()
                + zonedDateTime.getHour() + zonedDateTime.getMinute() + zonedDateTime.getSecond();

        System.out.println(localtime);
        System.out.println(localdate);
        System.out.println(alltime);

        System.out.println(month0 + "我是分割符" + month1);
    }

    /**
     * 处理特定的日期
     * 各入传入的年月日，或时分秒 等参数创建一个LocalDate和LocalTime对象
     */
    public void getSpecialTime() {
        LocalDate localDateSpecial = LocalDate.of(2018, 9, 11);
        LocalTime localTimeSpecial = LocalTime.of(18, 15, 15);
        ZoneOffset zoneOffset = ZoneOffset.of("+07:00");
        ZonedDateTime zonedDateTimeCompare = ZonedDateTime.of(localDateSpecial, localTimeSpecial, zoneOffset);

        System.out.println(localDateSpecial);
        System.out.println(localTimeSpecial);
        System.out.println(zonedDateTimeCompare);
        System.out.println(zonedDateTimeCompare.toLocalDateTime()); // 只是返回一个没有时间戳的时间，并不会转成本地时区的时间
    }

    public void timeCompare() {
        // TODO
    }

    /**
     * ZoneID 是获取的文字版的时区
     * ZoneOffset 使用数字的方式
     */
    public void aboutTimeZone() {
        // 获取当前的系统时区
        ZoneId systemZoneId = ZoneId.systemDefault();
        // 获取所有的时区列表
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(systemZoneId);
        zoneIds.stream()
                .filter(str -> str.contains("Europe"))
                .forEach(str -> System.out.println(str));

        System.out.println(LocalTime.now(ZoneId.of("+01:00")));

    }

    /**
     * 不同时区的时间相互转换
     * 通过时间戳来实现不同时区时间的相互转换
     */
    public void timeZoneConvert() {
        ZoneId lundun = ZoneId.of("+00:00");
        ZoneId shanghai = ZoneId.of("+08:00");
        // 获取零时区的时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now(shanghai);
        // 将时间转换成时间戳
        Instant is = zonedDateTime.toInstant();
        // 将时间戳转换成指定时区的时间
        LocalDateTime localDateTime = LocalDateTime.ofInstant(is, lundun);

        System.out.println(localDateTime);
    }

    /**
     * 时间戳相关操作
     */
    public void getTimeStamp() {
        // 获取当前的时间戳
        Instant is = Instant.now();
        // 从具体的时间中获取时间戳
        // 因为这里LocalDateTime是不含时区信息的，因此使用要给出时区。给出ZoneID 还不行
        Instant is0 = LocalDateTime.now().toInstant(ZoneOffset.of("+08:00"));
        // 从包含时区的时间内获取时间戳
        Instant is1 = ZonedDateTime.now().toInstant();
        long l = is1.toEpochMilli();
    }

    /**
     * 时间转日期
     */
    public void str2Date() {
        String date = "2018-02-12";
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDate);
    }

    /**
     * 日期转时间
     */
    public void date2Str() {
        ZonedDateTime zo = ZonedDateTime.now();
        String str = zo.format(DateTimeFormatter.ofPattern("yyyy年MM月dd HH时"));
        System.out.println(str);
    }

    /**
     * 比较连个日期之间的差异
     */
    public void getDiffDate() {
        String date = "2018年01月10日";
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy年MM月dd日"));

        Period p = Period.between(ld, localDate);
        // 这个的输出结果是只是天数的差异，并不涉其他时间
        long l = p.getDays();

        //Duration d = Duration.between(ld,localDate);
        //long l1 = d.toDays();
        // 这个才是我们真正需要的
        long l1 = ChronoUnit.DAYS.between(ld, localDate);


        System.out.println(l1);
    }

}
