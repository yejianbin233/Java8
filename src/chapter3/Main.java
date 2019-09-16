package chapter3;/**
 * Created by Administrator on 2019/9/12.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Main
 * @Description chapter 3 main run
 * @Date 2019/9/12 16:38
 **/
public class Main {
    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("src/chapter3/data.txt"))){
            return p.process(br);
        }
    }


    public static void main(String[] args) throws IOException {
        // 读取一行
        String oneLine = processFile((BufferedReader br) -> br.readLine());

        // 读取两行
        String towLine = processFile((BufferedReader br) -> br.readLine()+br.readLine());

        System.out.println(oneLine);
        System.out.println(towLine);
    }
}
