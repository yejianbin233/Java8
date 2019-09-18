package chapter12;/**
 * Created by Administrator on 2019/9/16.
 */

import java.time.LocalTime;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName LocalTimeDemo
 * @Description LocalTime Demo
 * @Date 2019/9/16 16:16
 **/
public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
    }
}
