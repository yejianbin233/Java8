package chapter8.stragegy;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName ValidationStrategy
 * @Description 函数式校验接口
 * @Date 2019/9/23 11:01
 **/
public interface ValidationStrategy {
    boolean execution(String s);
}
