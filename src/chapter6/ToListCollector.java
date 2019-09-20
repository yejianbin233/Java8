package chapter6;/**
 * Created by Administrator on 2019/9/20.
 */

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName ToListCollector
 * @Description 自定义一个收集器，用于计算集合中所有元素的值
 * @Date 2019/9/20 17:32
 **/
public class ToListCollector<T> implements Collector<T, List<T>, List<T>>{

    @Override
    public Supplier<List<T>> supplier() {
        // 返回一个累加器
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        // 归约操作，逐个添加
        return List::add;
    }


    @Override
    public Function<List<T>, List<T>> finisher() {
        // 类型转换，List<T> 转换为 List<T>
        return Function.identity();
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        // 子流的归并操作
        return (list1,list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // 两个收集器的结果一致
//        List<Integer> result = integerList.stream().filter(i -> i>5).collect(toList());
        List<Integer> result = integerList.stream().filter(i -> i>5).collect(new ToListCollector<Integer>());
        System.out.println(result);
    }
}