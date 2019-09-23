package chapter8.stragegy;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Run
 * @Description 策略模式普通使用与 Lambda 转换
 * @Date 2019/9/23 11:03
 **/
public class Run {
    public static void main(String[] args) {
        // 策略模式普通使用
        ValidationStrategy isAllLowerCaseStrategy = new IsAllLowerCase();
        isAllLowerCaseStrategy.execution("");
        ValidationStrategy isNumeric = new IsNumeric();
        isNumeric.execution("");

        /*
        * Lambda 表达式使用：
        *
        * 1. ValidationStratey 是一个函数式编程接口
        * */
        ValidationStrategy isAllLowerCaseStrategyLam = (String s) -> {
            System.out.println("Lambda 模拟调用 isAllLowerCaseStrategy...");
            return false;
        };

        ValidationStrategy isNumericStrategyLam = (String s) -> {
            System.out.println("Lambda 模拟调用 IsNumericStrategy...");
            return false;
        };

        isAllLowerCaseStrategyLam.execution("");
        isNumericStrategyLam.execution("");

    }
}
