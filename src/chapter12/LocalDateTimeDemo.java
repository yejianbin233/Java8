package chapter12;/**
 * Created by Administrator on 2019/9/16.
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName LocalDateTimeDemo
 * @Description LocalDateTime Demo
 * @Date 2019/9/16 16:23
 **/
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        // 构建 LocalDateTime 对象
        LocalDateTime dt = LocalDateTime.now();
        LocalDateTime dt1 = LocalDateTime.of(date,time);
        // 传递 LocalDate 或 LocalTime 对象
        LocalDateTime dt2 = date.atTime(time);
        LocalDateTime dt3 = time.atDate(date);

        // LocalDateTime -> LocalDate 或 LocalTime
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
    }
}
