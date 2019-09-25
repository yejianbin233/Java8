package chapter11.run1112;/**
 * Created by Administrator on 2019/9/24.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Run
 * @Description
 * @Date 2019/9/24 11:29
 **/
public class Run {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Shop shop = new Shop();

        long start = System.nanoTime();
        Future<Double> future = shop.getPriceAsync("apple");
        long costTime = System.nanoTime() - start;
        System.out.println("execute time - " + costTime/1000000);

        int i=5;
        while(i>0){
            // 休眠五秒
            System.out.println("倒计时 - " + i);
            Thread.sleep(1000);
            i--;
        }

        double price = future.get();
        System.out.println("price - " + price);
        costTime = System.nanoTime() - start;
        System.out.println("execute time - " + costTime/1000000);
    }
}
