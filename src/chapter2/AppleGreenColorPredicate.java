package chapter2;/**
 * Created by Administrator on 2019/9/12.
 */

import chapter1.Apple;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName AppleGreenColorPredicate
 * @Description 定义筛选绿色苹果的策略
 * @Date 2019/9/12 15:56
 **/
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
