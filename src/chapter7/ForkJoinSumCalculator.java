package chapter7;/**
 * Created by Administrator on 2019/9/11.
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName ForkJoinSumCalculator
 * @Description
 * @Date 2019/9/11 17:52
 **/
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    // 要求和的数组 - long 类型
    private final long[] numbers;
    // 子任务处理的起始位置
    private final int start;
    // 子任务处理的结束位置
    private final int end;
    // 不再进行拆分的子任务数组大小
    public static final long THRESHOLD = 1000;

    public ForkJoinSumCalculator(long[] numbers, int start, int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute(){
        int length = end - start;
        // 如果任务处理的数组大小小于阈值 - THRESHOLD
        if (length <= THRESHOLD) {
            // 不拆分任务，顺序执行
            return computeSequentially();
        }

        // 将任务进行拆分，拆分为两个子任务
        // 创建一个新的 ForkJoinSumCalculator 对象
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,start,start+length/2);
        // 利用另一个 ForkJoinPool 线程异步执行新创建的子任务
        leftTask.fork();

        // 创建一个新的 ForkJoinSumCalculator 对象
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,start+length/2,end);
        // 在当前线程顺序执行另一个子任务
        Long rightResult = rightTask.compute();
        // 等到异步执行的子任务结果
        Long leftResult = leftTask.join();

        // 子任务结果合并
        return leftResult + rightResult;
    }
    // 任务计算
    private long computeSequentially(){
        long sum = 0;
        for (int i=start;i<end;i++) {
            sum+=numbers[i];
        }
        return sum;
    }

    // 测试方法
    public static long forkJoinSum(long n){
        // 利用 LongStream 生成 long[]
        long[] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers,0,numbers.length);
        // 使用 ForkJoinPool 来执行
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        System.out.println(forkJoinSum(100));
    }
}
