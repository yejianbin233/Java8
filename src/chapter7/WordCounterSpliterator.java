package chapter7;/**
 * Created by Administrator on 2019/9/11.
 */

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName WordCounterSpliterator
 * @Description 自动义 Spliterator 类，用于配合 Stream 的并行流使用，使之能够正确拆分字符串中的字词
 * @Date 2019/9/11 17:50
 **/
public class WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String s) {
        this.string = s;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        // 处理当前字符
        action.accept(string.charAt(currentChar++));
        // 如果还有字符需要处理，则返回 true
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            // 返回 null 表示要解析的 String 已经足够小，可以顺序处理
            return null;
        }

        // 拆分字符串，按照剩余需要处理的字符的二分之一进行拆分
        for (int splitPos = currentSize / 2 + currentChar;
             splitPos < string.length(); splitPos++) {
            // 如果当前的字符不是字符串，那么向右移直到找到一个字符为空格，然后对其进行拆分
            if (Character.isWhitespace(string.charAt(splitPos))) {
                WordCounterSpliterator spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));

                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
    private int countWords(Stream<Character> stream){
        // 串行
        //WordCounter wordCounter = stream.reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine);
        // 并行
        WordCounter wordCounter = stream.parallel().reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine);

        return wordCounter.getCounter();
    }

    public static void main(String[] args) {
        String s = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 ";
        Spliterator<Character> spliterator = new WordCounterSpliterator(s);
        // 使用 StreamSupport 来创建流，true 代表创建一个并行流，并利用自定义 Spliterator 对象来进行字符串拆分
        Stream<Character> stream = StreamSupport.stream(spliterator,true);
        System.out.println(new WordCounterSpliterator("").countWords(stream));
    }
}
