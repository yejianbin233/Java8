package chapter8.observer;/**
 * Created by Administrator on 2019/9/23.
 */

/**
 * @author yejianbin
 * @version 1.0
 * @ClassName NYTimes
 * @Description TODO
 * @Date 2019/9/23 11:37
 **/
public class NYTimes implements Observer {
    @Override
    public void notify(String context) {
        System.out.println("NYTimes Observer." + context);
    }
}
