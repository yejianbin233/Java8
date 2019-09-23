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
//        Validator validator = new Validator(new IsAllLowerCase());
//        validator.validate("");

//        Validator validator = new Validator(new IsNumeric());
//        validator.validate("");

        /*
        * Lambda 表达式使用：
        *
        * 1. ValidationStratey 是一个函数式编程接口
        * */
//        Validator validatorLam = new Validator((String s) -> {
//            System.out.println("Lambda 模拟调用 isAllLowerCaseStrategy...");
//            return false;
//        });
//        validatorLam.validate("");

//        Validator validatorLam = new Validator((String s) -> {
//            System.out.println("Lambda 模拟调用 IsNumericStrategy...");
//            return false;
//        });
//        validatorLam.validate("");

    }
}
