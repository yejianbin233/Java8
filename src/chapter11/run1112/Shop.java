package chapter11.run1112;/**
 * Created by Administrator on 2019/9/24.
 */

import java.util.concurrent.*;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Shop
 * @Description
 * @Date 2019/9/24 11:22
 **/
public class Shop {

    // 定义线程数
    private int size = 5;
    // 获取产品的价格 - 同步方式
    public double getPrice(String productName){
        return calculatePrice(productName);
    }
    public Future<Double> getPriceAsync(String productName){
        CompletableFuture<Double> future = new CompletableFuture<>();

        new Thread(() -> {
            // 创建线程执行任务，并将任务结果通过 complete 传递给 CompletableFuture 实例.
            try{
                double price = calculatePrice(productName);
                // 异常.
                int i = 1/0;
                future.complete(price);
            } catch (Exception ex) {
                // 将导致 CompletableFuture 内发生问题的异常抛出.
                future.completeExceptionally(ex);
            }
        }).start();

        return future;
    }

    // getPriceAsync() 功能的 Lambda 实现（效果完全一致，包括异常处理），使用 CompletableFuture 的 supplyAsync()
    public Future<Double> getPriceAsyncByLam(String name){
        // CompletableFuture 使用自定义线程池.
        return CompletableFuture.supplyAsync(() -> calculatePrice(name),getExecutor());
    }

    /*
    *
    * 定制执行器 - 根据运行环境、任务类型（计算密集型、IO 密集型）自定义线程的数量
    * */
    private Executor getExecutor(){
        return Executors.newFixedThreadPool(Math.min(size, 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                // 设置守护线程，与一般线程效率一样，只不过因为守护线程的性质，当非守护线程不存在时，应用停止。
                t.setDaemon(true);
                return t;
            }
        });
    }
    private double calculatePrice(String name){
        DelayUtil.delay();
        return 10.0;
    }
}
