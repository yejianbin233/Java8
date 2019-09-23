package chapter8.observer;/**
 * Created by Administrator on 2019/9/23.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName Feed
 * @Description TODO
 * @Date 2019/9/23 17:08
 **/
public class Feed implements Subject{
    private List<Observer> observers;

    public Feed() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.stream().forEach(o -> o.notify(tweet));
    }

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new LeMonde());
        feed.registerObserver(new Guardian());

        feed.notifyObservers("eating Feed.");
    }
}
