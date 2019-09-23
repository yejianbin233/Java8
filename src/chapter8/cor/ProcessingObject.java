package chapter8.cor;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName ProcessingObject
 * @Description 责任链模式
 * @Date 2019/9/23 17:19
 **/
public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    // 调整 - 返回设置的下一个 successor,流水线式操作
    public ProcessingObject<T> setSuccessor(ProcessingObject<T> successor){
        this.successor = successor;
        return successor;
    }

    public T handle(T input){
        // 按照责任链的顺序来执行任务.
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(input);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}
