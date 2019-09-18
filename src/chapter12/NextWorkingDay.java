package chapter12;/**
 * Created by Administrator on 2019/9/16.
 */

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName NextWorkingDay
 * @Description NextWorkingDay
 * @Date 2019/9/16 17:36
 **/
public class NextWorkingDay implements TemporalAdjuster{

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

        int dayToAdd = 1;

        if (dow == DayOfWeek.FRIDAY) {
            dayToAdd = 3;
        } else if (dow == DayOfWeek.SATURDAY) {
            dayToAdd = 2;
        }
        return temporal.plus(dayToAdd,ChronoUnit.DAYS);
    }
}
