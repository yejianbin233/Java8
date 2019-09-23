package chapter8.stragegy;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName IsAllLowerCase
 * @Description 小写校验规则
 * @Date 2019/9/23 11:02
 **/
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execution(String s) {
        System.out.println("模拟字符串小写校验规则...");
        return false;
    }
}
