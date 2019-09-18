package chapter12;/**
 * Created by Administrator on 2019/9/16.
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName TemporalAjusterDemo
 * @Description TemporalAjuster Demo
 * @Date 2019/9/16 17:21
 **/
public class TemporalAjusterDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate d1 = date.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate d2 = date.with(lastDayOfMonth());
    }
}
