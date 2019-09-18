package chapter12;/**
 * Created by Administrator on 2019/9/16.
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName LocalDateMain
 * @Description LocalDate Demo
 * @Date 2019/9/16 16:05
 **/
public class LocalDateMain {
//    public static void main(String[] args) {
//        // 通过 of 方法来创建指定日期
//        LocalDate date = LocalDate.of(2019,9,16);
//        // 通过 now 方法从系统时钟中获取当前日期
//        // LocalDate date = LocalDate.now();
//        int year = date.getYear();
//        Month month = date.getMonth();
//        int day = date.getDayOfMonth();
//        DayOfWeek dow = date.getDayOfWeek();
//        int len = date.lengthOfMonth();
//        boolean leap = date.isLeapYear();
//        // 输出 -> 2019-09-16
//        System.out.println(date.toString());
//
//        // 可以通过 get 方法，直接传递 TemporalField 参数来获取 LocalDate 的属性值
//        date.get(ChronoField.YEAR);
//        date.get(ChronoField.MONTH_OF_YEAR);
//        date.get(ChronoField.DAY_OF_MONTH);
//    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate d1 = date.withYear(2018);
        LocalDate d2 = date.withMonth(5);
        LocalDate d3 = date.withDayOfMonth(25);
        LocalDate d4 = date.with(ChronoField.MONTH_OF_YEAR,8);

        // 对 LocalDate 的修改只会创建对象的一个副本，返回一个修改了属性的对象，原始的 LocalDate 对象不发生改变。
    }
}
