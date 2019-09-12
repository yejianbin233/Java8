package chapter7;/**
 * Created by Administrator on 2019/9/11.
 */

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName WordCounter
 * @Description 计算字符串包含的所有字词
 * @Date 2019/9/11 17:47
 **/
public class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter,boolean lastSpace){
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    // 迭代算法，统计字符串的所有字词数量 - 配合 Stream 来使用
    // 该算法存在一个问题：
    // 使用 Stream 并行流来统计字符串的字词数量结果不正确，原因是在并行计算时会将字符串按照默认的规则拆分，导致一个字词被错误地拆分为多个字词，进行重复计算
    // 解决方式：自定义 Spliterator 方法来自定义并行拆分字符串的规则
    public WordCounter accumulate(Character c){
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter,true);
        } else {
            return lastSpace ? new WordCounter(counter+1,false) : this;
        }
    }
    // 合并两个 WordCounter，把其计算器（counter）加起来，lastSpace 仅用于适应构造函数，无需关心
    public WordCounter combine(WordCounter wordCounter){
        return new WordCounter(counter+wordCounter.counter,wordCounter.lastSpace);
    }

    public int getCounter(){
        return counter;
    }

    private int countWords(Stream<Character> stream){
        // 串行
        WordCounter wordCounter = stream.reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine);
        // 并行
        //WordCounter wordCounter = stream.parallel().reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine);

        return wordCounter.getCounter();
    }

    public static void main(String[] args) {
        String s = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 ";
        Stream<Character> characters = IntStream.range(0,s.length()).mapToObj(s::charAt);
        System.out.println(new WordCounter(0,true).countWords(characters));
    }
}
