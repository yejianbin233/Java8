package chapter8.cor;/**
 * Created by Administrator on 2019/9/23.
 */

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Run
 * @Description
 * @Date 2019/9/23 17:28
 **/
public class Run {
    public static void main(String[] args) {

        // 普通方式使用责任链模式
        ProcessingObject<String> headerTextProcessing = new HeaderTextProcessing();
        SpellCheckerProcessing spellCheckerProcessing = new SpellCheckerProcessing();
        ProcessingObject<String> headerTextProcessing2 = new HeaderTextProcessing();

        // 流水线式操作
        headerTextProcessing.setSuccessor(spellCheckerProcessing).setSuccessor(headerTextProcessing2);

        // 执行.
        headerTextProcessing.handle("start ~~~");

        System.out.println("\n\n\n");
        // Lambda 方式使用责任链模式
        UnaryOperator<String> first = (String s) -> "processing first \t" + s;
        UnaryOperator<String> second = (String s) -> "processing second \t" + s;
        UnaryOperator<String> three = (String s) -> "processing three \t" + s;

        Function<String,String> pipeLine = first.andThen(second).andThen(three);

        String result = pipeLine.apply("1");
        System.out.println(result);
    }
}
