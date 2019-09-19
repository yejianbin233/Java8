package chapter5;/**
 * Created by Administrator on 2019/9/19.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName FilterAndSliceDemo
 * @Description 筛选和切片
 * @Date 2019/9/19 11:16
 **/
public class FilterAndSliceDemo {

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        for (int i=0;i<10;i++){
            if (i % 2 == 0) {
                arrList.add(0);
            }
            arrList.add(i);
            arrList.add(i);
        }

        Stream<Integer> distinctStream = arrList.stream().distinct();
        // 去重之后,组成一个[0，9] 区间的有序 List
        List<Integer> distinctList = distinctStream.collect(toList());

        Stream<Integer> filterStream =  arrList.stream().distinct().filter(i -> i > 0);
        // 筛选之后,组成一个[1，9] 区间的有序 List
        List<Integer> filterList = filterStream.collect(toList());

        Stream<Integer> skipStream = arrList.stream().distinct().filter(i -> i > 0).skip(2);
        // 筛选之后,组成一个[3，9] 区间的有序 List，按照 List 的顺序跳过
        List<Integer> skipList = skipStream.collect(toList());

        Stream<Integer> limitStream = arrList.stream().distinct().filter(i -> i > 0).skip(2).limit(1);
        // 截取 3
        List<Integer> limitList = limitStream.collect(toList());

        Stream<Integer> limitStream2 = arrList.stream().distinct().filter(i -> i > 0).skip(2).limit(100);
        // 如果截取的长度大于元素的数量，将会获取全部的元素
        List<Integer> limitList2 = limitStream2.collect(toList());
    }
}
