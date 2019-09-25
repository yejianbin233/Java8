package chapter11;/**
 * Created by Administrator on 2019/9/24.
 */

import java.util.concurrent.*;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Run111
 * @Description 清单 11-1
 * @Date 2019/9/24 11:03
 **/
public class Run111 {
    public static void main(String[] args) throws Exception {
        // 使用 Executors（线程池工具类）来创建一个缓存线程池。
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Callable 实例封装 Future 实例，并提交给线程池异步执行 Callable 中的 Future 任务
        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return 10.0;
            }
        });

        int i=5;
        while(i>0){
            // 休眠五秒
            System.out.println("倒计时 - " + i);
            Thread.sleep(1000);
            i--;
        }
        // 获取异步操作的结果，如果最终结果被阻塞，无法得到结果，那么在最多等待 1 秒后退出
        // 如果 future 任务执行完毕，get() 会立刻返回结果，否则会阻塞当前线程，直到操作完成。
        Double result = future.get(1, TimeUnit.SECONDS);
        System.out.println("future result - " + result);

        // 终止运行.
        System.exit(-1);
    }
}
