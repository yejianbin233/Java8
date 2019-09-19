package chapter4;/**
 * Created by Administrator on 2019/9/19.
 */

import chapter1.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName StreamFeatureDemo
 * @Description Stream Feature Demo
 * @Date 2019/9/19 10:42
 **/
public class StreamFeatureDemo {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Apple apple = Apple.builder();
            apples.add(apple);
            System.out.println(apple.toString());
        }
        Stream<String> colorStream = apples.stream().filter(apple -> {
            System.out.println(apple.getWeight());
            return apple.getWeight() > 150;
        }).map(apple -> {
            System.out.println(apple.getColor());
            return apple.getColor();
        });
        System.out.println("=========");
        // 不调用终端操作，不会有任何显示输出.
        colorStream.collect(Collectors.toList());

        /*
        *
        *
            Apple{color='blue', weight=138}
            Apple{color='green', weight=166}
            Apple{color='yellow', weight=179}
            Apple{color='blue', weight=181}
            Apple{color='blue', weight=114}
            Apple{color='yellow', weight=123}
            Apple{color='yellow', weight=174}
            Apple{color='yellow', weight=140}
            Apple{color='red', weight=147}
            Apple{color='green', weight=151}
            =========
            138
            166
            green
            179
            yellow
            181
            blue
            114
            123
            174
            yellow
            140
            147
            151
            green
        *
        *
        * */

    }
}
