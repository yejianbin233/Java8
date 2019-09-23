package chapter8.observer;/**
 * Created by Administrator on 2019/9/23.
 */

import java.util.List;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Subject
 * @Description 管理并通知观察者
 * @Date 2019/9/23 17:06
 **/
public interface Subject {
    // 注册观察者
    void registerObserver(Observer observer);
    // 当发生某种情况时，通知观察者
    void notifyObservers(String tweet);
}
