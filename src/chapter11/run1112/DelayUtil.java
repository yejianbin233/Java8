package chapter11.run1112;/**
 * Created by Administrator on 2019/9/24.
 */

import java.util.concurrent.TimeUnit;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName DelayUtil
 * @Description 模拟延迟
 * @Date 2019/9/24 11:23
 **/
public class DelayUtil {
    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
