package chapter11.run1114;/**
 * Created by Administrator on 2019/9/24.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Discount
 * @Description 折扣类
 * @Date 2019/9/24 17:13
 **/
public class Discount {
    public enum Code {
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;
        Code(int percentage){
            this.percentage = percentage;
        }
    }
}
