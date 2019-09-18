package chapter12;/**
 * Created by Administrator on 2019/9/16.
 */

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName DurationAndPeriodDemo
 * @Description DurationAndPeriod Demo
 * @Date 2019/9/16 16:42
 **/
public class DurationAndPeriodDemo {
    public static void main(String[] args) {
        Duration d1 = Duration.between(LocalTime.of(10,10),LocalTime.now());
        Duration d2 = Duration.between(LocalDateTime.of(2019,9,6,10,10),LocalDateTime.now());
        Duration d3 = Duration.between(Instant.ofEpochMilli(3),Instant.now());
        /*
        *
        * 注意：
        *
        * 1. 不能将 LocalDateTime 和 Instant 混用，否则会抛出 DateTimeException 异常
        * 2. 如果需要以 年、月、日的方式对时间单位建模，可以使用 Period 类
        * */
        Period tenDays = Period.between(LocalDate.of(2019,9,6)
                                        ,LocalDate.of(2019,9,16));

        // Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);

        Period tendays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2,6,1);
    }
}
