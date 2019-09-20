package chapter6;/**
 * Created by Administrator on 2019/9/20.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName CollectorsDemo
 * @Description Collectors Demo 预定义收集器演示
 * @Date 2019/9/20 16:48
 **/
public class CollectorsDemo {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("apple", 12));
        fruits.add(new Fruit("peach", 15));
        fruits.add(new Fruit("banana", 20));

        System.out.println("===========================");
        // 计算元素总数目
//        long result = fruits.stream().collect(Collectors.counting());
//        long result = fruits.stream().count();

//        Optional<Fruit> result = fruits.stream().collect(Collectors
//                .maxBy(comparing(Fruit::getPrice))); // 最大值

//        Optional<Fruit> result = fruits.stream().collect(Collectors
//                .minBy(comparing(Fruit::getPrice))); // 最小值

//        int result = fruits.stream().collect(summingInt(Fruit::getPrice));
        // 接受一个把对象映射为求和所需 int 的函数

//        long result = fruits.stream().collect(summingLong(Fruit::getPrice));
        // 接受一个把对象映射为求和所需 long 的函数

//        double result = fruits.stream().collect(summingDouble(Fruit::getPrice));
        // 接受一个把对象映射为求和所需 double 的函数

//        double result = fruits.stream().collect(averagingInt(Fruit::getPrice));
        // 计算数值的平均数

//        IntSummaryStatistics result = fruits.stream().collect(summarizingInt(Fruit::getPrice));
        // 一次操作可获取的多个结果（总量、平均值、最大值、最小值）,将结果存放在 IntSummaryStatistics 中

//        String result = fruits.stream().map(Fruit::getName).collect(joining(", "));
        // 连接字符串

//        Map<String,List<Fruit>> result = fruits.stream().collect(groupingBy(Fruit::getName));
        // 分组

//        Map<String,Map<Integer,List<Fruit>>> result = fruits.stream().collect(groupingBy(Fruit::getName,groupingBy(Fruit::getPrice)));
        // 嵌套分组，先按照 name 分成一组后再按照 price 划分，得出 result

        Map<String,Long> result = fruits.stream().collect(groupingBy(Fruit::getName,counting()));
        // 按子组收集数据 - 计算分组中元素的数量


        System.out.println(result);
    }
}
