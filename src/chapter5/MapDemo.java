package chapter5;/**
 * Created by Administrator on 2019/9/19.
 */

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName MapDemo
 * @Description 映射
 * @Date 2019/9/19 11:32
 **/
public class MapDemo {
    public static void main(String[] args) {
        List<String> arrList = Arrays.asList("nihao","nihaoya","nihaoma","hello?");
        // 将 List 中的字符串转换为对应的长度
        List<Integer> strLength = arrList.stream().map(String::length).collect(toList());

        // 如果要实现将 List 的字符全部取出、通过 split 分离，再去重，最后组成一个新的字符串，如何实现？ result = nihaoymel?
        // map() 将字符串转换成了Stream<String[]>，无法通过 distinct() 去重（Sting[] 比较内存地址）
        List<String[]> strs = arrList.stream().map(s -> s.split(""))
                .distinct().collect(toList());
        // flatMap 将数组流（Stream<String[]>）都合并成一个字符串流（Stream<String>），然后去重得到正确的数据。
        String resultStr = arrList.stream().map(s -> s.split(""))
                                           .flatMap(Arrays::stream)
                                           .distinct()
                                           .collect(joining());
    }
}
