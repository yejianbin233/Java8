package chapter3;/**
 * Created by Administrator on 2019/9/12.
 */

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName BufferedReaderProcessor
 * @Description 函数式接口，用于处理 BufferedReader 操作
 * @Date 2019/9/12 16:41
 **/
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
